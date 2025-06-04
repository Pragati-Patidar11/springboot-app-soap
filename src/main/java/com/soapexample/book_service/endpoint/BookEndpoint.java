package com.soapexample.book_service.endpoint;

import com.soapexample.book_service.AddBookRequest;
import com.soapexample.book_service.AddBookResponse;
import com.soapexample.book_service.GetBookRequest;
import com.soapexample.book_service.GetBookResponse;
import com.soapexample.book_service.entities.Book;
import com.soapexample.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
public class BookEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/book";

    private final BookService bookService;

    @Autowired
    public BookEndpoint(BookService bookService) {
        this.bookService = bookService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBookRequest")
    @ResponsePayload
    public GetBookResponse getBook(@RequestPayload GetBookRequest request) {
        Book book = bookService.getBookById(request.getId());

        GetBookResponse response = new GetBookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddBookRequest")
    @ResponsePayload
    public AddBookResponse addBook(@RequestPayload AddBookRequest request) {
        Book newBook = new Book();
        newBook.setTitle(request.getTitle());
        newBook.setAuthor(request.getAuthor());

        Book savedBook = bookService.addBook(newBook);

        AddBookResponse response = new AddBookResponse();
        response.setId(savedBook.getId());
        response.setTitle(savedBook.getTitle());
        response.setAuthor(savedBook.getAuthor());

        return response;
    }
}
