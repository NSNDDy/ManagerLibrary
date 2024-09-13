package org.example.managerdemo.dto.request;

import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.managerdemo.entity.Book;
import org.example.managerdemo.entity.User;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingRequest {

   @NotNull(message = "User is mandatory")
   private Integer userId;

   @NotNull(message = "Book is mandatory")
   private Integer bookId;

   @NotNull(message = "Borrow date is mandatory")
   private Date dateBorrowed;

   @NotNull(message = "Due date is mandatory")
   private Date dueDate;
}
