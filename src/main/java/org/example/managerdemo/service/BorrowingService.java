package org.example.managerdemo.service;

import org.example.managerdemo.dto.request.BorrowingRequest;
import org.example.managerdemo.dto.response.BorrowingResponse;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface BorrowingService {

    List<BorrowingResponse> getAllBorrowings();

    BorrowingResponse getBorrowingById(Integer id);

    BorrowingResponse createBorrowing(BorrowingRequest borrowingreq);

    BorrowingResponse updateBorrowing(Integer id, BorrowingRequest borrowingreq);

    void deleteBorrowing(Integer id);
}
