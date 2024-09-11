package org.example.managerdemo.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BorrowingResponse {
   private Integer id;
   private Integer userId;
   private Integer bookId;
   private String dateBorrowed;
   private String dueDate;

}
