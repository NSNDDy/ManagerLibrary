package org.example.managerdemo.controller;

import org.example.managerdemo.dto.ApiResponse;
import org.example.managerdemo.dto.response.UserBorrowingBookResponse;
import org.example.managerdemo.service.UserBorrowingBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/borrowing")
public class UserBorrowingBookController {

    private final UserBorrowingBookService userBorrowingBookService;

    public UserBorrowingBookController(UserBorrowingBookService userBorrowingBookService){
        this.userBorrowingBookService = userBorrowingBookService;
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<List<UserBorrowingBookResponse>>> getdata(@PathVariable Integer id){
        List<UserBorrowingBookResponse> userBorrowingBookResponseList = userBorrowingBookService.getdata(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,"Danh sách người mượn",userBorrowingBookResponseList));

    }
}
