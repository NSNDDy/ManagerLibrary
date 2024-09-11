package org.example.managerdemo.Service;

import org.example.managerdemo.dto.Request.UserRequest;

public interface UserService {
    void saveUser(UserRequest user);
    void deleteUser(int id);
}
