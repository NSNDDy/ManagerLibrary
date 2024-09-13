package org.example.managerdemo.service.impl;

import org.example.managerdemo.dto.response.UserResponse;
import org.example.managerdemo.entity.User;
import org.example.managerdemo.exception.ResourceNotFoundException;
import org.example.managerdemo.repository.UserRepository;
import org.example.managerdemo.service.UserService;
import org.example.managerdemo.dto.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void saveUser(UserRequest user) {
        validateUserRequest(user);
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setGender(user.getGender());
        newUser.setMail(user.getMail());
        newUser.setPassword(user.getPassword());
        newUser.setPhone(user.getPhone());
        newUser.setAddress(user.getAddress());
        userRepository.save(newUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users
                .stream().map(user
                        -> new UserResponse(user.getUserId(), user.getName(), user.getGender()
                        , user.getMail(), user.getPassword()
                        , user.getPhone(), user.getAddress()))
                .collect(Collectors.toList());

    }

   /* @Override
    public UserResponse getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);

        try {
            if (userOptional.isEmpty()) {
                throw new ResourceNotFoundException("User not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = userOptional.get();
        return new UserResponse(user.getUserId(), user.getName(), user.getGender(),
                user.getMail(), user.getPassword(), user.getPhone(), user.getAddress());

    }*/
    @Override
    public UserResponse getUserById(Integer id) {
        return userRepository.findById(id)
                .map(user -> new UserResponse(user.getUserId(), user.getName(), user.getGender(),
                                                                user.getMail(), user.getPassword(),
                                                                user.getPhone(), user.getAddress()
                )).orElseThrow(() -> new ResourceNotFoundException("User not found"));

    }
    @Override
    public UserResponse updateUser(Integer id, UserRequest usersreq) {
        validateUserRequest(usersreq);

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setName(usersreq.getName());
        user.setGender(usersreq.getGender());
        user.setMail(usersreq.getMail());
        user.setPassword(usersreq.getPassword());
        user.setPhone(usersreq.getPhone());
        user.setAddress(usersreq.getAddress());

        User updateUser = userRepository.save(user);

        return new UserResponse(updateUser.getUserId(), updateUser.getName(), updateUser.getGender(),
                updateUser.getMail(), updateUser.getPassword(), updateUser.getPhone(), updateUser.getAddress());
    }

    private void validateUserRequest(UserRequest user) {

    }


    @Override
    public void deleteUser(Integer id ) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }


}
