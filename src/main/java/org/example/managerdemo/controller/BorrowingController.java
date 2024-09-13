package org.example.managerdemo.controller;

import jakarta.validation.Valid;
import org.example.managerdemo.dto.ApiResponse;
import org.example.managerdemo.dto.request.BorrowingRequest;
import org.example.managerdemo.dto.response.BorrowingResponse;
import org.example.managerdemo.service.BorrowingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowing")
public class BorrowingController {

    private BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService){
        this.borrowingService = borrowingService;
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<BorrowingResponse>>> getAllBorrowings(){
        List<BorrowingResponse> borrowingrep = borrowingService.getAllBorrowings();
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,"Danh sách mượn",borrowingrep));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BorrowingResponse>> getBorrowingById(@PathVariable Integer id){
        BorrowingResponse borowingrep = borrowingService.getBorrowingById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,"Get Borrowing By Id",borowingrep));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BorrowingResponse>> createBorrowing(@Valid @RequestBody BorrowingRequest request){
        BorrowingResponse brep = borrowingService.createBorrowing(request);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,"Create Borrowing Success", brep));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BorrowingResponse>>  updateBorrowing(@PathVariable Integer id, @Valid @RequestBody BorrowingRequest request){
        BorrowingResponse borrowingResponse = borrowingService.updateBorrowing(id, request);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Update Success", borrowingResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteBorrowing(@PathVariable Integer id){
        borrowingService.deleteBorrowing(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Delete Success", ""));
    }

}
