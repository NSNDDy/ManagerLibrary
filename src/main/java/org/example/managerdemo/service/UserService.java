package org.example.managerdemo.service;

import org.example.managerdemo.dto.request.UserRequest;
import org.example.managerdemo.dto.response.UserResponse;
import org.example.managerdemo.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserRequest user);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Integer id);

    UserResponse updateUser(Integer id,UserRequest usersreq);

    void deleteUser(Integer id);
}
