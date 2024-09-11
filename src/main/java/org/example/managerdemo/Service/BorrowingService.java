package org.example.managerdemo.Service;

import org.example.managerdemo.Conf.DateFormatter;
import org.example.managerdemo.Entity.Book;
import org.example.managerdemo.Entity.Borrowing;
import org.example.managerdemo.Entity.User;
import org.example.managerdemo.Exception.ResourceNotFoundException;
import org.example.managerdemo.Repository.BookRepository;
import org.example.managerdemo.Repository.BorrowedRepository;
import org.example.managerdemo.Repository.UserRepository;
import org.example.managerdemo.Request.BorrowingRequest;
import org.example.managerdemo.Response.BorrowingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService {

    @Autowired
    private BorrowedRepository borrowedRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<BorrowingResponse> getAllBorrowing() {
        List<Borrowing> borrowings = borrowedRepository.findAll();

        return borrowings.stream().map(borrowing -> {
            BorrowingResponse response = new BorrowingResponse();
            response.setId(borrowing.getId());
            response.setUserId(borrowing.getUser().getUserId());
            response.setBookId(borrowing.getBook().getBookId());

            String fomattedDateBorrowed = DateFormatter.formatDate(borrowing.getDateBorrowed());
            String fomattedDueDate = DateFormatter.formatDate(borrowing.getDueDate());

            response.setDateBorrowed(fomattedDateBorrowed);
            response.setDueDate(fomattedDueDate);
            return response;
        }).toList();
    }

    public Borrowing getBorrowingById(int id) {
        return borrowedRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Borrowing not found"));
    }

    public BorrowingResponse createBorrowing(BorrowingRequest borrowingRequest) {
        Optional<User> user = userRepository.findById(borrowingRequest.getUserId());
        Optional<Book> book = bookRepository.findById(borrowingRequest.getBookId());
        if (user.isPresent() && book.isPresent()) {

            Borrowing borrowing = new Borrowing();

            borrowing.setUser(user.get());
            borrowing.setBook(book.get());
            borrowing.setDateBorrowed(borrowingRequest.getDateBorrowed());
            borrowing.setDueDate(borrowingRequest.getDueDate());

            Borrowing savedBorrowing = borrowedRepository.save(borrowing);

            BorrowingResponse response = new BorrowingResponse();
            response.setId(savedBorrowing.getId());
            response.setUserId(savedBorrowing.getUser().getUserId());
            response.setBookId(savedBorrowing.getBook().getBookId());

            String fomattedDateBorrowed = DateFormatter.formatDate(savedBorrowing.getDateBorrowed());
            String fomattedDueDate = DateFormatter.formatDate(savedBorrowing.getDueDate());

            response.setDateBorrowed(fomattedDateBorrowed);
            response.setDueDate(fomattedDueDate);

            return response;

        } else {
            throw new ResourceNotFoundException("User or book not found");
        }
    }


}
