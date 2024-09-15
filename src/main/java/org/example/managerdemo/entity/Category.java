package org.example.managerdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

   @Id
   @OneToOne
   @JoinColumn(name = "book_id", referencedColumnName = "book_Id")
   private Book book;

   @NotNull(message = "Name is mandatory")
   private String name;

   @NotNull(message = "Details is mandatory")
   private String details;
}
