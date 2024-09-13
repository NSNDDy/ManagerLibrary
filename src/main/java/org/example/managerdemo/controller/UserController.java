package org.example.managerdemo.controller;

import jakarta.validation.Valid;
import org.example.managerdemo.dto.response.UserResponse;
import org.example.managerdemo.entity.User;
import org.example.managerdemo.dto.ApiResponse;
import org.example.managerdemo.dto.request.UserRequest;

import org.example.managerdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers(){
        List<UserResponse> users = userService.getAllUsers();
        /*ApiResponse<List<UserResponse>> response = new ApiResponse<>(HttpStatus.OK, users,"Danh sách người dùng");*/
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,"Danh sách người dùng", users));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable Integer id){
        UserResponse userResponse = userService.getUserById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Danh sách người dùng", userResponse));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createUser(@Valid @RequestBody UserRequest user){
        log.info("Creating user with data: {}", user);
        userService.saveUser(user);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Tạo tài khoản thành công", "Tạo tài khoản thành công"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(@PathVariable Integer id,@Valid @RequestBody UserRequest req ){
        UserResponse updateUser = userService.updateUser(id,req);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật thành công", updateUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,"Xóa thành công", null));
    }

}
