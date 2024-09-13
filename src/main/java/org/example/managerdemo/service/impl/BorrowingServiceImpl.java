package org.example.managerdemo.service.impl;

import org.example.managerdemo.dto.request.BorrowingRequest;
import org.example.managerdemo.dto.response.BorrowingResponse;
import org.example.managerdemo.entity.Book;
import org.example.managerdemo.entity.Borrowing;
import org.example.managerdemo.entity.User;
import org.example.managerdemo.exception.ResourceNotFoundException;
import org.example.managerdemo.repository.BookRepository;
import org.example.managerdemo.repository.BorrowedRepository;
import org.example.managerdemo.repository.UserRepository;
import org.example.managerdemo.service.BorrowingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingServiceImpl implements BorrowingService {


    private final BorrowedRepository borrowedRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public BorrowingServiceImpl(BorrowedRepository borrowedRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.borrowedRepository = borrowedRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public List<BorrowingResponse> getAllBorrowings() {

        List<Borrowing> borrowings = borrowedRepository.findAll();

        return borrowings.stream()
                .map(borrowing -> new BorrowingResponse(
                        borrowing.getId(), borrowing.getUser()
                        , borrowing.getBook(), borrowing.getDateBorrowed()
                        , borrowing.getDueDate()))
                .collect(Collectors.toList());

    }

    @Override
    public BorrowingResponse getBorrowingById(Integer id) {
        return borrowedRepository.findById(id)
                .map(borrowing -> new BorrowingResponse(
                        borrowing.getId(), borrowing.getUser()
                        , borrowing.getBook(), borrowing.getDateBorrowed()
                        , borrowing.getDueDate())).orElseThrow(() -> new ResourceNotFoundException("Brrowing not found!"));
    }

    @Override
    public BorrowingResponse createBorrowing(BorrowingRequest borrowingreq) {
        User user = userRepository.findById(borrowingreq.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));

        Book book = bookRepository.findById(borrowingreq.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found!"));

        Borrowing borrowing = new Borrowing();
        borrowing.setUser(user);
        borrowing.setBook(book);
        borrowing.setDateBorrowed(borrowingreq.getDateBorrowed());
        borrowing.setDueDate(borrowingreq.getDueDate());

        borrowedRepository.save(borrowing);
        return new BorrowingResponse(borrowing.getId(),
                borrowing.getUser(),
                borrowing.getBook(),
                borrowing.getDateBorrowed(),
                borrowing.getDueDate());

    }

    @Override
    public BorrowingResponse updateBorrowing(Integer id, BorrowingRequest borrowingreq) {

        Borrowing borrowing = borrowedRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brrowing not found!"));

        borrowing.setDateBorrowed(borrowingreq.getDateBorrowed());
        borrowing.setDueDate(borrowingreq.getDueDate());

        borrowedRepository.save(borrowing);

        return new BorrowingResponse(borrowing.getId(), borrowing.getUser()
                , borrowing.getBook(), borrowing.getDateBorrowed()
                , borrowing.getDueDate());

    }

    @Override
    public void deleteBorrowing(Integer id) {
        Borrowing borrowing = borrowedRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brrowing not found!"));
        borrowedRepository.delete(borrowing);

    }
}
