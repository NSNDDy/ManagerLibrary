package org.example.managerdemo.Service;

import org.example.managerdemo.Entity.Book;
import org.example.managerdemo.Exception.ResourceNotFoundException;
import org.example.managerdemo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(int id, Book updateBook){
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        book.setTitle(updateBook.getTitle());
        book.setAuthor(updateBook.getAuthor());
        book.setPublisher(updateBook.getPublisher());
        book.setDateOfPulication(updateBook.getDateOfPulication());
        book.setCategory(updateBook.getCategory());
        return bookRepository.save(book);
    }

    public void deleteBook(int id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        bookRepository.delete(book);
    }


}
