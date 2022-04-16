package com.lemilica.books.controller;

import com.lemilica.books.entity.Book;
import com.lemilica.books.entity.Genre;
import com.lemilica.books.exception.BadRequestException;
import com.lemilica.books.repository.BookRepository;
import com.lemilica.books.service.NextSequenceService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Operation(summary = "Get all books from the system")
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Operation(summary = "Get all genres from the system")
    @GetMapping(path = "/genres")
    public List<Genre> getGenres() {
        return Stream.of(Genre.values()).collect(Collectors.toList());
    }

    @Operation(summary = "Get a book by its id")
    @GetMapping(path = "/{id}")
    public Book getBookById(@Parameter(description = "id of book to be fetched") @PathVariable("id") int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No book with id: " + id));
    }

    @Operation(summary = "Create new book")
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        book.setId(nextSequenceService.getNextSequence(Book.SEQUENCE_NAME));
        return bookRepository.save(book);
    }

    @Operation(summary = "Update existing book by its id")
    @PutMapping(path = "/{id}")
    public Book updateBook(@Parameter(description = "id of book to be updated") @PathVariable("id") int id,
                           @RequestBody Book book) {
        if (!bookExists(id)) {
            throw new BadRequestException("No book with id: " + id);
        }
        book.setId(id);
        return bookRepository.save(book);
    }

    @Operation(summary = "Delete a book by its id")
    @DeleteMapping(path = "/{id}")
    public void deleteBook(@Parameter(description = "id of book to be deleted") @PathVariable("id") int id) {
        if (!bookExists(id)) {
            throw new BadRequestException("No book with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    private boolean bookExists(final int id) {
        return bookRepository.existsById(id);
    }

}
