package com.soapexample.book_service.service;

import com.soapexample.book_service.entities.Book;
import com.soapexample.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBookById(long id) {
        return bookRepository.findById(id)
                .orElse(new Book(id, "Unknown", "Unknown"));
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
