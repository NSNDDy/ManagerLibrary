package org.example.managerdemo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.managerdemo.entity.Book;
import org.example.managerdemo.entity.User;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingResponse {

    Integer id;
    User user;
    Book book;
    Date dateBorrowed;
    Date dueDate;

}
