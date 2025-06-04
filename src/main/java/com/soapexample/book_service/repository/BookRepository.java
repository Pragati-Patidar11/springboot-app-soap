package com.soapexample.book_service.repository;

import com.soapexample.book_service.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long>{

}
