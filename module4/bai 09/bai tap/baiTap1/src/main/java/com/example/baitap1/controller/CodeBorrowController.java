package com.example.baitap1.controller;

import com.example.baitap1.entity.Book;
import com.example.baitap1.entity.Code;
import com.example.baitap1.exception.NotAvailableException;
import com.example.baitap1.exception.WrongCodeException;
import com.example.baitap1.service.IBookService;
import com.example.baitap1.service.ICodeService;
import com.example.baitap1.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CodeBorrowController {
    @Autowired
    IBookService bookService;
    @Autowired
    ICodeService codeService;
    @Autowired
    IStatusService statusService;

    @GetMapping("/viewborrow")
    public String view(Model model){
        List<Code> codeBorrowList=codeService.findAll();
        model.addAttribute("codeBorrowList",codeBorrowList);
        return"code/view_code_borrow";

    }
    @GetMapping("returnCode")
    public String returnPage(Model model, @RequestParam Integer id){
        Code code=codeService.findById(id);
        Book book=code.getBook();
        model.addAttribute("book",book);
        model.addAttribute("code",code);
        return"code/returnBook";
    }
    @PostMapping("/returnCode")
    public String returnBook(Model model, @ModelAttribute Book book,@ModelAttribute Code code)
            throws WrongCodeException, NotAvailableException {
        bookService.returnBook(book,code.getCode());
        return"redirect:books";
    }
}
