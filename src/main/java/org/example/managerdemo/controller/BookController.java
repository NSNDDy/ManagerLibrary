package org.example.managerdemo.controller;


import jakarta.validation.Valid;
import org.example.managerdemo.dto.ApiResponse;
import org.example.managerdemo.dto.request.BookRequest;
import org.example.managerdemo.dto.response.BookResponse;
import org.example.managerdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<BookResponse>>> getAllBooks(){
        List<BookResponse> books = bookService.getAllBooks();
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Danh sách sản phẩm", books));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> getBookById(@PathVariable Integer id){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Danh sách sách", bookService.getBookById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createBook(@Valid @RequestBody BookRequest bookreq){
        bookService.createBook(bookreq);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Tạo sản phẩm", "bookreq"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> updateBook(@PathVariable Integer id, @Valid @RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật thành công", bookService.updateBook(id, bookRequest)));
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
    }







}


