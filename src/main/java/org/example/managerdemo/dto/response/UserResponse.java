package org.example.managerdemo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private int id;
    private String name;
    private String gender;

    private String mail;

    private String password;

    private String phone;

    private String address;
}
