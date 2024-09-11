package org.example.managerdemo.Repository;

import org.example.managerdemo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
