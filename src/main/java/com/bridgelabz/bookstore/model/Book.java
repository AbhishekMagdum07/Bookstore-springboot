package com.bridgelabz.bookstore.model;


import com.bridgelabz.bookstore.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="Book_Table")

public class Book {
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
        private int bookId;
        private String bookName;
        private String bookDescription;
        private String bookLogo;
        private long bookPrice;

    public Book(BookDTO bookDTO) {
        this.updateBook(bookDTO);
    }

    public void updateBook(BookDTO bookDTO) {
        this.bookName=bookDTO.getBookName();
           this.bookDescription=     bookDTO.getBookDescription();
            this.bookLogo=    bookDTO.getBookLogo();
             this.bookPrice=  bookDTO.getBookPrice();

    }
}
