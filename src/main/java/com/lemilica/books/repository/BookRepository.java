package com.lemilica.books.repository;

import com.lemilica.books.entity.Book;
import com.lemilica.books.entity.Genre;
import com.lemilica.books.exception.BadRequestException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

//    private List<Book> books;
//
//    @PostConstruct
//    public void initBooks() {
//        books = new ArrayList<>();
//        Book book = Book.builder()
//                .id(1L)
//                .genres(Collections.singletonList(Genre.DRAMA))
//                .available(true)
//                .title("Na Drini cuprija")
//                .author("Ivo Andric")
//                .price(1000.5)
//                .imageUrl("")
//                .build();
//        books.add(book);
//    }
//
//    public List<Book> getAllBooks() {
//        return books;
//    }
//
//    public Book addBook(Book book) {
//        book.setId((long) books.size() + 1);
//        books.add(book);
//        return book;
//    }
//
//    public void deleteBook(Long id) {
//        books.removeIf(e -> e.getId().equals(id));
//    }
//
//    public Book updateBook(Book book) {
//        if (books.stream().noneMatch(e -> e.getId().equals(book.getId()))) {
//            throw new BadRequestException("No book with id: " + book.getId());
//        }
//        books.removeIf(e -> e.getId().equals(book.getId()));
//        books.add(book);
//        return book;
//    }
//
//    public Book getBookById(Long id) {
//        return books.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new BadRequestException("No book with id: " + id));
//    }
}
