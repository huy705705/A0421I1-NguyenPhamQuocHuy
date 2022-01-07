package com.example.baitap1.controller;

import com.example.baitap1.entity.Book;
import com.example.baitap1.exception.NotAvailableException;
import com.example.baitap1.exception.NotBorrowException;
import com.example.baitap1.exception.WrongCodeException;
import com.example.baitap1.service.IBookService;
import com.example.baitap1.service.ICodeService;
import com.example.baitap1.service.IStatusService;
import com.example.baitap1.validation.ReturnCodeWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    ICodeService iCodeService;
    @Autowired
    IStatusService statusService;

    @GetMapping()
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/books")
    public String view(Model model) {
        model.addAttribute("booklist", bookService.findAll());
        return "book/view";
    }

    @GetMapping("book/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "book/create";
    }

    @PostMapping("/create")
    public String createBook(Model model, @Validated @ModelAttribute Book book, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute(book);
            return "book/create";
        }
        bookService.save(book);
        return "redirect:books";
    }

    @GetMapping("/borrow")
    public String borrow(Model model, @RequestParam Integer id)
            throws NotAvailableException, WrongCodeException {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("availableCode", bookService.getNextAvailableCode(book));
        return "book/borrow";

    }

    @PostMapping("/borrow")
    public String borrowBook(@ModelAttribute Book book, @RequestParam Integer usedCode) {
        bookService.borrow(book, usedCode);
        return "redirect:books";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        bookService.delete(id);
        return "redirect:books";
    }

    @GetMapping("/return")
    public String returnPage(Model model, @RequestParam Integer id, @ModelAttribute ReturnCodeWrapper returnCodeWrapper)
            throws NotBorrowException {
        Book book = bookService.findById(id);
        if (bookService.checkNoUsedCode(book)){
            throw  new NotBorrowException();
        }
        model.addAttribute("returnCodeWrapper",returnCodeWrapper);
        model.addAttribute("book",book);
        return"book/return";
    }
    @PostMapping("/return")
    public String returnBook(Model model,@ModelAttribute Book book,
                             @Validated @ModelAttribute ReturnCodeWrapper returnCodeWrapper,
                            BindingResult bindingResult) throws WrongCodeException, NotAvailableException {
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("returnCodeWrapper",returnCodeWrapper);
            model.addAttribute("book",book);
            return"book/return";

        }
        bookService.returnBook(book, Integer.valueOf(returnCodeWrapper.getReturnCode()));
        return "redirect:books";
    }
    @GetMapping("/create_code_status")
    public String createCodeStatus(){
        statusService.createStatus();
        return "index";
    }

    @ExceptionHandler(NotAvailableException.class)
    public String notAvailable() {
        return "error_not_available";
    }

    @ExceptionHandler(WrongCodeException.class)
    public String wrongCode() {
        return "error_wrong_code";
    }

    @ExceptionHandler(NotBorrowException.class)
    public String notBorrow() {
        return "error_not_borrow";
    }
}
