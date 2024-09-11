package org.example.managerdemo.Controller;

import jakarta.validation.Valid;
import org.example.managerdemo.Entity.Admin;
import org.example.managerdemo.dto.Request.AdminRequest;
import org.example.managerdemo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public Admin createAdmin(@RequestBody AdminRequest adminRequest) {
        return adminService.createAdmin(adminRequest.getUserId(), adminRequest.getRole());
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Integer id){
        Admin admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }


    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Integer id, @Valid @RequestBody AdminRequest admin){
        return adminService.updateAdmin(id , admin.getUserId(), admin.getRole());
        /*return (ResponseEntity<Admin>) ResponseEntity.ok();*/
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable Integer id){
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }




}
