package org.example.managerdemo.Service;

import org.example.managerdemo.Entity.User;
import org.example.managerdemo.Exception.ResourceNotFoundException;
import org.example.managerdemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(int id, User updateUser){

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setName(updateUser.getName());
        user.setGender(updateUser.getGender());
        user.setMail(updateUser.getMail());
        user.setPassword(updateUser.getPassword());
        user.setPhone(updateUser.getPhone());
        user.setAddress(updateUser.getAddress());
        return userRepository.save(user);
    }

    public void deleteUser(int id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }


}
