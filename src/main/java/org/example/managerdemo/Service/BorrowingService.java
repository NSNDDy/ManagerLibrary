package org.example.managerdemo.Service;

import org.example.managerdemo.Entity.Book;
import org.example.managerdemo.Entity.Borrowing;
import org.example.managerdemo.Entity.User;
import org.example.managerdemo.Exception.ResourceNotFoundException;
import org.example.managerdemo.Repository.BookRepository;
import org.example.managerdemo.Repository.BorrowedRepository;
import org.example.managerdemo.Repository.UserRepository;
import org.example.managerdemo.common.DateUtils;
import org.example.managerdemo.dto.Request.BorrowingRequest;
import org.example.managerdemo.Response.BorrowingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

            String fomattedDateBorrowed = DateUtils.formatDate(borrowing.getDateBorrowed());
            String fomattedDueDate = DateUtils.formatDate(borrowing.getDueDate());

            response.setDateBorrowed(fomattedDateBorrowed);
            response.setDueDate(fomattedDueDate);
            return response;
        }).toList();
    }

    public BorrowingResponse getBorrowingById(Integer id){
        Optional<Borrowing> borrowings = borrowedRepository.findById(id);

        if (!borrowings.isPresent()) {
            throw new ResourceNotFoundException("Borrowing with id " +id + "not found");
        }
        Borrowing borrowing = borrowings.get();

        BorrowingResponse response = new BorrowingResponse();
        response.setId(borrowing.getId());
        response.setUserId(borrowing.getUser().getUserId());
        response.setBookId(borrowing.getBook().getBookId());

        String fomattedDateBorrowed = DateUtils.formatDate(borrowing.getDateBorrowed());
        String fomattedDueDate = DateUtils.formatDate(borrowing.getDueDate());

        response.setDateBorrowed(fomattedDateBorrowed);
        response.setDueDate(fomattedDueDate);

        return response;

       /* return borrowings.stream().map(borrowing -> {
            BorrowingResponse response = new BorrowingResponse();
            response.setId(borrowing.getId());
            response.setUserId(borrowing.getUser().getUserId());
            response.setBookId(borrowing.getBook().getBookId());

            String fomattedDateBorrowed = DateFormatter.formatDate(borrowing.getDateBorrowed());
            String fomattedDueDate = DateFormatter.formatDate(borrowing.getDueDate());

            response.setDateBorrowed(fomattedDateBorrowed);
            response.setDueDate(fomattedDueDate);
            return response;
        }).toList();*/

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

            String fomattedDateBorrowed = DateUtils.formatDate(savedBorrowing.getDateBorrowed());
            String fomattedDueDate = DateUtils.formatDate(savedBorrowing.getDueDate());

            response.setDateBorrowed(fomattedDateBorrowed);
            response.setDueDate(fomattedDueDate);

            return response;

        } else {
            throw new ResourceNotFoundException("User or book not found");
        }
    }

    public BorrowingResponse updateBorrowing(Integer id,BorrowingRequest borrowingRequest) {
        Optional<Borrowing> existingBorrowing = borrowedRepository.findById(id);

        if (!existingBorrowing.isPresent()){
            throw new ResourceNotFoundException("Borrowing with id " +id + "not found");
        }

        Borrowing borrowing = existingBorrowing.get();

        Optional<User> user = userRepository.findById(borrowingRequest.getUserId());
        Optional<Book> book = bookRepository.findById(borrowingRequest.getBookId());
        if (user.isPresent()) {

            borrowing.setUser(user.get());borrowing.setUser(user.get());
        }else {
            throw new ResourceNotFoundException("User not found");
        }

        if (book.isPresent()){
            borrowing.setBook(book.get());
        }else {
        throw new ResourceNotFoundException("Book not found");
        }


        borrowing.setDateBorrowed(borrowingRequest.getDateBorrowed());
        borrowing.setDueDate(borrowingRequest.getDueDate());

        Borrowing updateBorrowing = borrowedRepository.save(borrowing);

        BorrowingResponse response = new BorrowingResponse();
        response.setId(updateBorrowing.getId());
        response.setUserId(updateBorrowing.getUser().getUserId());
        response.setBookId(updateBorrowing.getBook().getBookId());

        String formatteddateBorrowed = DateFormatter.formatDate(updateBorrowing.getDateBorrowed());
        String formattedDueDate = DateFormatter.formatDate(updateBorrowing.getDueDate());

        response.setDateBorrowed(formatteddateBorrowed);
        response.setDueDate(formattedDueDate);

        return response;
    }

    public void deleteBorrowing(Integer id) {
        borrowedRepository.deleteById(id);
    }




}
