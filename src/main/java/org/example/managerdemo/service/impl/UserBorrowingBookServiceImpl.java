package org.example.managerdemo.service.impl;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.managerdemo.common.DateUtils;
import org.example.managerdemo.dto.response.UserBorrowingBookResponse;
import org.example.managerdemo.entity.Borrowing;
import org.example.managerdemo.repository.BorrowedRepository;
import org.example.managerdemo.service.UserBorrowingBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserBorrowingBookServiceImpl implements UserBorrowingBookService {

    private final BorrowedRepository borrowedRepository;

    @Override
    public List<UserBorrowingBookResponse> getdata(Integer userId) {

        List<Borrowing> borrowings = borrowedRepository.findAll();

        return borrowings.stream().map(borrowing -> new UserBorrowingBookResponse(
                borrowing.getUser().getUserId(),
                borrowing.getUser().getName(),
                borrowing.getBook().getTitle(),
                DateUtils.formatDate(borrowing.getDateBorrowed()),
                DateUtils.formatDate(borrowing.getDueDate())
        )).collect(Collectors.toList());

    }
}
