package org.example.managerdemo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBorrowingBookResponse {
    Integer userId;
    String name;
    String title;
    String dateBorrowed;
    String dueDate;
}
