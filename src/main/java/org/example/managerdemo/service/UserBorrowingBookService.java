package org.example.managerdemo.service;

import org.example.managerdemo.dto.response.UserBorrowingBookResponse;

import java.util.List;

public interface UserBorrowingBookService {

    List<UserBorrowingBookResponse> getdata(Integer userId);
}
