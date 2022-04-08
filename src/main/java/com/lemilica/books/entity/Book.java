package com.lemilica.books.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Book {

    private Long id;
    private String title;
    private String author;
    private List<Genre> genres;
    private Double price;
    private Boolean available;
    private String imageUrl;

}
