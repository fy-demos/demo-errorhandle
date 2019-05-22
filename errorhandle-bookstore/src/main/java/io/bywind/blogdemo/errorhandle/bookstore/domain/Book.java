package io.bywind.blogdemo.errorhandle.bookstore.domain;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotBlank(message = "name should not be blank")
    private String name;
    @NotBlank
    private String author;
    @NotNull
    private Details details;

    @Data
    public static class Details implements Serializable {
        private static final long serialVersionUID = 4132866801194318806L;
        private String isbn;
        private Double price;
    }
}
