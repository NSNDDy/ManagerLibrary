package org.example.managerdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
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
@Table(name = "return_items")
public class Return {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer borrowId;

   @ManyToOne
   @JoinColumn(name = "user_id", referencedColumnName = "user_Id")
   private User user;

   @ManyToOne
   @JoinColumn(name = "book_id", referencedColumnName = "book_Id")
   private Book book;

   @NotNull(message = "Date returned is mandatory")
   private Date dateReturned;

   @NotNull(message = "Due date is mandatory")
   private Date dueDate;

   @PositiveOrZero(message = "Fine must be zero or positive")
   private double fine;
}
