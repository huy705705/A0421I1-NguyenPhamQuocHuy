package com.example.baitap1.service;

import com.example.baitap1.entity.Book;
import com.example.baitap1.entity.Code;
import com.example.baitap1.exception.NotAvailableException;
import com.example.baitap1.exception.WrongCodeException;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);

    void borrow(Book book, Integer usedCode);

    void delete(Integer id);

    Code getNextAvailableCode(Book book) throws NotAvailableException, WrongCodeException;
    void returnBook(Book book, Integer returnCode) throws NotAvailableException, WrongCodeException;


    public boolean checkNoUsedCode(Book book);
}
