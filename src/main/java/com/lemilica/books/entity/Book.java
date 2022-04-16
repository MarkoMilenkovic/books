package com.lemilica.books.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Book {

    @Transient
    public static final String SEQUENCE_NAME = "books_sequence";

    @Id
    private int id;
    private String title;
    private String author;
    private List<Genre> genres;
    private Double price;
    private Boolean available;
    private String imageUrl;

}
