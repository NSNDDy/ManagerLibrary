package org.example.managerdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @OneToOne
   @JoinColumn(name = "user_id", referencedColumnName = "user_Id")
   private User user;

   @NotBlank(message = "Role is mandatory")
   private String role;

}
