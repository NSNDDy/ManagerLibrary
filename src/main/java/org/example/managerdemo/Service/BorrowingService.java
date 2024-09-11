package org.example.managerdemo.Service;

import org.example.managerdemo.Entity.Book;
import org.example.managerdemo.Entity.Borrowing;
import org.example.managerdemo.Entity.User;
import org.example.managerdemo.Exception.ResourceNotFoundException;
import org.example.managerdemo.Repository.BookRepository;
import org.example.managerdemo.Repository.BorrowedRepository;
import org.example.managerdemo.Repository.UserRepository;
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

    public List<Borrowing> getAllBorrowing(){
        return borrowedRepository.findAll();
    }

    public Borrowing getBorrowingById(int id){
        return borrowedRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Borrowing not found"));
    }

    public Borrowing createBorrowing(Borrowing borrowing){
        return borrowedRepository.save(borrowing);
    }

    public Borrowing updateBorrowing(int id, Borrowing borrowing){
        Borrowing borrowing1 = borrowedRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Borrowing not found"));
        borrowing1.setBook(borrowing.getBook());
        borrowing1.setUser(borrowing.getUser());
        borrowing1.setDateBorrowed(borrowing.getDateBorrowed());
        borrowing1.setDueDate(borrowing.getDueDate());
        return borrowedRepository.save(borrowing1);
    }

    public void deleteBorrowing(int id){
        borrowedRepository.deleteById(id);
    }

    public Optional<User> findUserById(Integer id){
        return userRepository.findById(id);
    }

    public Optional<Book> findBookById(Integer id){
        return bookRepository.findById(id);
    }



}
