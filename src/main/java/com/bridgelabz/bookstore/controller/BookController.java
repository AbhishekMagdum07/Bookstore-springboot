package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.responseDto.ResponseDTO;
import com.bridgelabz.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

@Autowired
private BookService bookService;

    @PostMapping("/saveBooks")
    public ResponseEntity<ResponseDTO> saveBook(@RequestBody BookDTO bookDTO) {
        ResponseDTO savedBook = bookService.saveBook(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book saved successfully ", savedBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Endpoint to update an existing book
    @PutMapping("/update/{bookId}")
    public ResponseEntity<ResponseDTO> updateBook(@PathVariable int bookId, @RequestBody BookDTO bookDTO) {
        Book updatedBook = bookService.updateBook(bookId, bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book updated successfully", updatedBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Endpoint to delete a book by its ID
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseDTO> deleteBook(@PathVariable int bookId) {
        bookService.deleteBook(bookId);
        ResponseDTO responseDTO = new ResponseDTO("Book deleted successfully", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Endpoint to get a book by its ID
    @GetMapping("/get/{bookId}")
    public ResponseEntity<ResponseDTO> getBook(@PathVariable int bookId) {
        Book book = bookService.getBookById(bookId);
        ResponseDTO responseDTO = new ResponseDTO("Book retrieved successfully", book);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Endpoint to get all books
    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        ResponseDTO responseDTO = new ResponseDTO("Books retrieved successfully", allBooks);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Endpoint to change the price of a book
    @PatchMapping("/{bookId}/price")
    public ResponseEntity<ResponseDTO> changeBookPrice(
                                                       @PathVariable int bookId,
                                                       @RequestParam long price) {
        Book book = bookService.changeBookPrice( bookId, price);
        ResponseDTO responseDTO = new ResponseDTO("Book price changed successfully", book);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

