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

   @OneToOne
   @JoinColumn(name = "borrow_id2", referencedColumnName = "Id")
   private Borrowing borrowing;

   @NotNull(message = "Date returned is mandatory")
   private Date dateReturned;

   @NotNull(message = "Due date is mandatory")
   private Date dueDate;

   @PositiveOrZero(message = "Fine must be zero or positive")
   private double fine;
}
