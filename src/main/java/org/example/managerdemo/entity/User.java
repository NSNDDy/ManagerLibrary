package org.example.managerdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "user_id")
   private Integer userId;

   @NotBlank(message = "name is mandatory")
   @Size(max = 100, message = "name should not exceed 100 characters")
   private String name;

   @NotBlank(message = "gender is mandatory")
   private String gender;

   @Email(message = "Email should be valid")
   @NotBlank(message = "mail is mandatory")
   private String mail;

   @NotBlank(message = "password is mandatory")
   @Size(min = 8, message = "Password should have at least 8 characters")
   private String password;

   @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits")
   private String phone;

   @NotBlank(message = "address is mandatory")
   private String address;
}
