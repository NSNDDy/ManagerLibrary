package org.example.managerdemo.service.impl;

import org.example.managerdemo.dto.request.BookRequest;
import org.example.managerdemo.dto.response.BookResponse;
import org.example.managerdemo.entity.Book;
import org.example.managerdemo.exception.ResourceNotFoundException;
import org.example.managerdemo.repository.BookRepository;
import org.example.managerdemo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void createBook(BookRequest bookreq) {
        validateBookRequest(bookreq);
        Book book = new Book();
        book.setTitle(book.getTitle());
        book.setAuthor(book.getAuthor());
        book.setPublisher(book.getPublisher());
        book.setDateOfPulication(book.getDateOfPulication());
        book.setCategory(book.getCategory());
        bookRepository.save(book);

    }

    @Override
    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books.stream()
                .map(book -> new BookResponse(book.getBookId(),book.getTitle()
                        ,book.getAuthor(),book.getPublisher()
                        ,book.getDateOfPulication(),book.getCategory()))
                .collect(Collectors.toList());
    }

    @Override
    public BookResponse getBookById(Integer id) {
        return bookRepository.findById(id)
                .map(book -> new BookResponse(book.getBookId(),book.getTitle()
                        ,book.getAuthor(),book.getPublisher()
                        ,book.getDateOfPulication(),book.getCategory()
                )).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

    }

    @Override
    public BookResponse updateBook(Integer id, BookRequest bookreq) {
        validateBookRequest(bookreq);

        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        book.setTitle(bookreq.getTitle());
        book.setAuthor(bookreq.getAuthor());
        book.setPublisher(bookreq.getPublisher());
        book.setDateOfPulication(bookreq.getDateOfPulication());
        book.setCategory(bookreq.getCategory());

        bookRepository.save(book);

        return new BookResponse(book.getBookId(),book.getTitle()
                ,book.getAuthor(),book.getPublisher()
                ,book.getDateOfPulication(),book.getCategory());
    }

    @Override
    public void deleteBook(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        bookRepository.delete(book);
    }

    private void validateBookRequest(BookRequest bookreq) {

    }


}
