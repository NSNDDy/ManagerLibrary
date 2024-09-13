package org.example.managerdemo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBorrowingBookResponse {
   private Integer userId;
   private String name;
   private String title;
   private String dateBorrowed;
   private String dueDate;
}
