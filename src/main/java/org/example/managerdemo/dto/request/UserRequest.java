package org.example.managerdemo.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

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