package org.example.managerdemo.Controller;

import org.example.managerdemo.Entity.Book;
import org.example.managerdemo.Entity.Borrowing;
import org.example.managerdemo.Entity.User;
import org.example.managerdemo.Repository.BorrowedRepository;
import org.example.managerdemo.Request.BorrowingRequest;
import org.example.managerdemo.Service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;


    @PostMapping
    public ResponseEntity<Borrowing> createBorrowing(@RequestBody BorrowingRequest borrowingRequest){
        Optional<User> user = borrowingService.findUserById(borrowingRequest.getUserId());
        Optional<Book> book = borrowingService.findBookById(borrowingRequest.getBookId());

        if (user.isPresent() && book.isPresent()){
            Borrowing borrowing = new Borrowing();

            borrowing.setUser(user.get());
            borrowing.setBook(book.get());
            borrowing.setDateBorrowed(borrowingRequest.getDateBorrowed());
            borrowing.setDueDate(borrowingRequest.getDueDate());

            Borrowing savedBorrowing = borrowingService.createBorrowing(borrowing);
            return ResponseEntity.ok(savedBorrowing);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<Borrowing> getAllBorrowing(){
        return borrowingService.getAllBorrowing();
    }

}
