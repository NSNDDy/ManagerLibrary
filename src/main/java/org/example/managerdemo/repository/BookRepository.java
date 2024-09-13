package org.example.managerdemo.repository;

import org.example.managerdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
