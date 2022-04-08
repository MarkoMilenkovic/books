package com.lemilica.books.controller;

import com.lemilica.books.entity.Book;
import com.lemilica.books.entity.Genre;
import com.lemilica.books.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @GetMapping(path = "/genres")
    public List<Genre> getGenres() {
        return Stream.of(Genre.values()).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookRepository.getBookById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.addBook(book);
    }

    @PutMapping(path = "/{id}")
    public Book updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        book.setId(id);
        return bookRepository.updateBook(book);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteBook(id);
    }

}
