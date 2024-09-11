package org.example.managerdemo.Controller;

import jakarta.validation.Valid;
import org.example.managerdemo.Entity.Book;
import org.example.managerdemo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable  Integer id){
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book){
        Book createBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createBook);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Book> updateBook(@PathVariable int id, @Valid @RequestBody Book book){
        Book updateBook = bookService.updateBook(id,book);
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Book> deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return  ResponseEntity.noContent().build();
    }



}
