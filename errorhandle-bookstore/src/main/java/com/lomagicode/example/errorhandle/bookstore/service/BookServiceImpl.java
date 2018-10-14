package com.lomagicode.example.errorhandle.bookstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.lomagicode.example.errorhandle.commons.error.BusinessException;
import com.lomagicode.example.errorhandle.bookstore.domain.Book;
import com.lomagicode.example.errorhandle.commons.error.CommonErrorCode;

/**
 * Created on Oct 10, 2018
 *
 * @author Chuan Qin
 */
@Service
public class BookServiceImpl implements BookService {

    private Map<Integer, Book> store = new HashMap<Integer, Book>() {
        private static final long serialVersionUID = 8772219288579551063L;
        {
            Book book = new Book();
            book.setId(1L);
            book.setName("人类简史");
            book.setAuthor("尤瓦尔•赫拉利 (Yuval Noah Harari)");
            Book.Details details = new Book.Details();
            details.setIsbn("9787508691312");
            details.setPrice(73.40);
            book.setDetails(details);
            put(1, book);
        }

    };

    @Override
    public List<Book> findAll() {
        List<Book> books = Lists.newArrayList();
        books.add(store.get(1));
        return books;
    }

    @Override
    public Book findOne(Long id) {
        if (id != 1L) {
            // =====>  此处也可以使用通用错误码中定义的 CommonErrorCode.RESOURCE_NOT_FOUND
            throw BusinessException.of(CommonErrorCode.NOT_FOUND, HttpStatus.BAD_REQUEST, "Book[id=" + id + "]");
        }
        return store.get(1);
    }

    @Override
    public Book save(Book book) {
        return book;
    }
}
