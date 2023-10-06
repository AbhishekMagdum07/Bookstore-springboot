package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.responseDto.ResponseDTO;

import java.util.List;

public interface BookService {
    ResponseDTO saveBook(BookDTO bookDTO);

    Book updateBook(int bookId, BookDTO bookDTO);

    void deleteBook(int bookId);

    Book getBookById(int bookId);

    List<Book> getAllBooks();


    Book changeBookPrice( int bookId, long price);
}
