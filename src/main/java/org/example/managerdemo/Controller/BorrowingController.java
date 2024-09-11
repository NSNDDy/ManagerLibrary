package org.example.managerdemo.Controller;

import org.example.managerdemo.dto.Request.BorrowingRequest;
import org.example.managerdemo.Response.BorrowingResponse;
import org.example.managerdemo.Service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;


    @PostMapping
    public ResponseEntity<BorrowingResponse> createBorrowing(@RequestBody BorrowingRequest borrowingRequest) {
        try {
            BorrowingResponse response = borrowingService.createBorrowing(borrowingRequest);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

   /* @GetMapping
    public List<Borrowing> getAllBorrowing() {
        return borrowingService.getAllBorrowing();
    }*/
    @GetMapping
    public ResponseEntity<List<BorrowingResponse>> getAllBorrowing(){
        List<BorrowingResponse> responses = borrowingService.getAllBorrowing();
        return ResponseEntity.ok(responses);
    }

}
