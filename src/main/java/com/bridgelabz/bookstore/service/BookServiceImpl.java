package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.customException.BookCustomException;
import com.bridgelabz.bookstore.customException.UserCustomException;
import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.repository.BookRepo;
import com.bridgelabz.bookstore.responseDto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    public ResponseDTO saveBook(BookDTO bookDTO) {
        Book bookData = new Book(bookDTO);
        bookRepo.save(bookData);
        return new ResponseDTO( "books details",bookData);
    }
    public Book updateBook(int bookId, BookDTO bookDTO) {
        Book bookData = getBookById(bookId);
        if (bookData == null) {
            throw new IllegalArgumentException("User not found with ID: " + bookId);
        }
        bookData.updateBook(bookDTO);
        return bookRepo.save(bookData);
    }
    public void deleteBook(int bookId) {
        Book bookData = getBookById(bookId);
        if (bookData == null) {
            throw new IllegalArgumentException("User not found with ID: " + bookId);
        }
        bookRepo.deleteById(bookId);
    }
    public Book getBookById(int bookId) {
        return bookRepo.findById(bookId).orElseThrow(() -> new UserCustomException("user with id: " + bookId + "not present"));
    }
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book changeBookPrice(int bookId, long price) {

        Book bookData = getBookById(bookId);
        if (bookData == null) {
            throw new BookCustomException("Book not found with ID: " + bookId);
        } else {
            bookData.setBookPrice(price);
            bookRepo.save(bookData);
            return bookData;
        }

    }
}