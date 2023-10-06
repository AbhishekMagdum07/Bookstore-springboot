package com.bridgelabz.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookDTO {
        private String bookName;
        private String bookDescription;
        private String bookLogo;
        private long bookPrice;

}
