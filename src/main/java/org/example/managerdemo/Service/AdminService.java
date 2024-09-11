package org.example.managerdemo.Service;

import org.example.managerdemo.Entity.Admin;
import org.example.managerdemo.Entity.User;
import org.example.managerdemo.Exception.ResourceNotFoundException;
import org.example.managerdemo.Repository.AdminRepository;
import org.example.managerdemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    public Admin createAdmin(Integer userId, String role) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        /*try {
            User user = userRepository.findById(userId);
        }catch (TimeoutException e){
            e.printStackTrace();
        }*/

        Admin admin = new Admin();
        admin.setUser(user);
        admin.setRole(role);

        return adminRepository.save(admin);

    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Integer id){
        return adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found!"));
    }


    public Admin updateAdmin(Integer id, Integer userId, String role){
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found "));

        if (userId != null){
            User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found "));
            admin.setUser(user);
        }

        if (role != null && role.isEmpty()){
            admin.setRole(role);
        }

        return adminRepository.save(admin);
    }

  /*  public Admin updateAdmin(Integer id, Admin updateAdmin){


        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found "));

        admin.setUser(updateAdmin.getUser());
        admin.setRole(updateAdmin.getRole());

        return adminRepository.save(admin);
    }*/

    public void deleteAdmin(Integer id){
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found "));
        adminRepository.delete(admin);
    }

}
