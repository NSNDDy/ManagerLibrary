package org.example.managerdemo.Controller;

import jakarta.validation.Valid;
import org.example.managerdemo.Entity.User;
import org.example.managerdemo.Service.UserService;
import org.example.managerdemo.Service.impl.UserServiceImpl;
import org.example.managerdemo.dto.ApiResponse;
import org.example.managerdemo.dto.Request.UserRequest;
import org.example.managerdemo.dto.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//
//    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable  int id) {
//        UserResponse user = userService.getUserById(id);
//        return  ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, user, ""));
//    }


   /* @PostMapping
    public ResponseEntity<User> createUser(
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String gender,
            @RequestParam String mail,
            @RequestParam String password,
            @RequestParam String phone
            ) {

        User user = new User();
        user.setName(name);
        user.setAddress(address);
        user.setGender(gender);
        user.setMail(mail);
        user.setPassword(password);
        user.setPhone(phone);


        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }*/
    @PostMapping
    public ResponseEntity<ApiResponse<String>> createUser(@Valid @RequestBody UserRequest user){
        userService.saveUser(user);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Tạo tài khoản thành công", "Tạo tài khoản thành công"));
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable int id, @Valid @RequestBody User user){
//        User updateUser = userService.updateUser(id,user);
//        return ResponseEntity.ok(updateUser);
//    }
//
//
    @PostMapping("/delete")
    public ResponseEntity<User> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
