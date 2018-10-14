package com.lomagicode.example.errorhandle.bookstore.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * Created on Oct 14, 2018
 *
 * @author Chuan Qin
 */
@Data
public class Book implements Serializable {
    private static final long serialVersionUID = -5873160771058832357L;

    private Long id;
    private String name;
    private String author;
    private Details details;

    @Data
    public static class Details implements Serializable {
        private static final long serialVersionUID = 4132866801194318806L;

        private String isbn;
        private Double price;
    }
}
