package org.example.managerdemo.dto.Request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BorrowingRequest {
   private Integer userId;
   private Integer bookId;
   private Date dateBorrowed;
   private Date dueDate;
}
