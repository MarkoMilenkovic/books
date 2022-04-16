package com.lemilica.books.controller;

import com.lemilica.books.entity.Book;
import com.lemilica.books.entity.Genre;
import com.lemilica.books.exception.BadRequestException;
import com.lemilica.books.repository.BookRepository;
import com.lemilica.books.service.NextSequenceService;
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
    private final NextSequenceService nextSequenceService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(path = "/genres")
    public List<Genre> getGenres() {
        return Stream.of(Genre.values()).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No book with id: " + id));
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        book.setId(nextSequenceService.getNextSequence(Book.SEQUENCE_NAME));
        return bookRepository.save(book);
    }

    @PutMapping(path = "/{id}")
    public Book updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        if (!bookExists(id)) {
            throw new BadRequestException("No book with id: " + id);
        }
        book.setId(id);
        return bookRepository.save(book);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        if (!bookExists(id)) {
            throw new BadRequestException("No book with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    private boolean bookExists(final int id) {
        return bookRepository.existsById(id);
    }

}
