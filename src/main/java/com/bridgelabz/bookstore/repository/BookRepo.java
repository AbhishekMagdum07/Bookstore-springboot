package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookRepo extends JpaRepository<Book,Integer> {

}
