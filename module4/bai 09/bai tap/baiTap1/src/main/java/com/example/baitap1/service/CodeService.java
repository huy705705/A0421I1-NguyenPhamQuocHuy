package com.example.baitap1.service;

import com.example.baitap1.entity.Book;
import com.example.baitap1.entity.Code;
import com.example.baitap1.entity.Status;
import com.example.baitap1.repository.IBookRepository;
import com.example.baitap1.repository.ICodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CodeService implements ICodeService {
    @Autowired
    IBookRepository bookRepository;

    @Autowired
    ICodeRepository codeRepository;


    @Override
    public List<Code> findAll() {
        return this.codeRepository.findAll();
    }

    @Override
    public Code findById(Integer id) {
        return this.codeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Code code) {
        codeRepository.save(code);
    }

    @Override
    public List<Code> findAllCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_Id(id);
    }

    @Override
    public List<Code> findAvailableCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_IdAndStatus_Id(id, 1);
    }

    @Override
    public List<Code> findUsedCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_IdAndStatus_Id(id, 2);
    }

    @Override
    public void returnBookByCode(Book book, Integer returnCode) {
        Code code = codeRepository.findById(returnCode).orElse(null);
        book = code.getBook();
        book.returnBook();
        bookRepository.save(book);
        code.setStatus(new Status(1, "available"));
    }
}
