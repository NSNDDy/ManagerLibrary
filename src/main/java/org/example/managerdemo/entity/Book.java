package org.example.managerdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "book_id")
   private Integer bookId;

   @NotBlank(message = "title is mandatory")
   private String title;

   @NotBlank(message = "author is mandatory")
   private String author;

   @NotBlank(message = "publisher is mandatory")
   private String publisher;

   @PastOrPresent(message = "Publication date should be in the past or present")
   private Date dateOfPulication;

   @NotBlank(message = "category is mandatory")
   private String category;

}
