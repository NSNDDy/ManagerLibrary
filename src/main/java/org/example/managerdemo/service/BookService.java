package org.example.managerdemo.service;


import org.example.managerdemo.dto.request.BookRequest;
import org.example.managerdemo.dto.response.BookResponse;

import java.util.List;

public interface BookService {

    void createBook(BookRequest bookreq);

    List<BookResponse> getAllBooks();

    BookResponse getBookById(Integer id);

    BookResponse updateBook(Integer id,BookRequest bookreq);

    void deleteBook(Integer id);

}
