package io.bywind.blogdemo.errorhandle.bookstore.web.endpoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.bywind.blogdemo.errorhandle.bookstore.domain.Book;
import io.bywind.blogdemo.errorhandle.bookstore.service.BookService;

/**
 * Created on Oct 09, 2018
 *
 * @author Chuan Qin
 */
@RestController
@RequestMapping("/books")
public class BookEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookEndpoint.class);

    private final BookService bookService;

    @Autowired
    public BookEndpoint(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    ResponseEntity listAll() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    ResponseEntity getOne(@PathVariable("id") Long id) {
        Book book = bookService.findOne(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    ResponseEntity addOne(@Validated @RequestBody Book book) {
        Book saved = bookService.save(book);
        LOGGER.info("Saved book: {}", saved);
        return ResponseEntity.ok(saved);
    }
}
