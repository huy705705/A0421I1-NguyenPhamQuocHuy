package com.example.baitap1.service;

import com.example.baitap1.entity.Book;
import com.example.baitap1.entity.Code;
import com.example.baitap1.entity.Status;
import com.example.baitap1.exception.NotAvailableException;
import com.example.baitap1.exception.WrongCodeException;
import com.example.baitap1.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Autowired
    ICodeService codeService;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
        Status available = new Status(1);
        for (int i = 0; i < book.getQuantity(); i++) {
            int n = 1000 + new Random().nextInt(90000);
            Code code = new Code(n, bookRepository.findById(book.getId()).orElse(null), available);
            book.generate(code);
            codeService.save(code);
        }
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void borrow(Book book, Integer usedCode) {
        List<Code> codeList = codeService.findAllCodeByBookId(book.getId());
        for (Code code : codeList) {
            if (code.getCode().equals(usedCode)) {
                code.setStatus((new Status(2, "used")));
                break;
            }
        }
        book.borrow();
        bookRepository.save(book);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Code getNextAvailableCode(Book book) throws NotAvailableException {
        List<Code> codeList = codeService.findAllCodeByBookId(book.getId());
        if (codeList.size() == 0) {
            throw new NotAvailableException();
        }
        return codeList.get(0);
    }

    @Override
    public void returnBook(Book book, Integer returnCode) throws NotAvailableException, WrongCodeException {
        List<Code> codeList = codeService.findUsedCodeByBookId(book.getId());
        if (codeList.size() == 0) {
            throw new NotAvailableException();
        }
        boolean isCorrectCode = false;
        for (Code code : codeList) {
            if (code.getCode().equals(returnCode)) {
                code.setStatus(new Status(1, "available"));
                codeService.save(code);
                book.returnBook();
                bookRepository.save(book);
                isCorrectCode = true;
                break;
            }
        }
        if (!isCorrectCode){
            throw  new WrongCodeException();
        }
    }

    @Override
    public boolean checkNoUsedCode(Book book) {
        List<Code> availableCodeList = codeService.findAvailableCodeByBookId(book.getId());
        List<Code> allCodeList = codeService.findAllCodeByBookId(book.getId());

        return availableCodeList.size() == allCodeList.size();
    }
}
