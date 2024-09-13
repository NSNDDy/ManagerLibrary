package org.example.managerdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Borrowing {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @ManyToOne
   @JoinColumn(name = "user_id", referencedColumnName = "user_Id")
   private User user;

   @ManyToOne
   @JoinColumn(name = "book_id", referencedColumnName = "book_Id")
   private Book book;

   @NotNull(message = "Borrow date is mandatory")
   private Date dateBorrowed;

   @NotNull(message = "Due date is mandatory")
   @Future(message = "Due date must be in the future")
   private Date dueDate;

}
