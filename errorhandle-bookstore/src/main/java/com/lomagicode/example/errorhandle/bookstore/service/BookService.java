package com.lomagicode.example.errorhandle.bookstore.service;

import java.util.List;

import com.lomagicode.example.errorhandle.bookstore.domain.Book;

/**
 * Created on Oct 10, 2018
 *
 * @author Chuan Qin
 */
public interface BookService {
    List<Book> findAll();

    Book findOne(Long id);

    Book save(Book book);
}
