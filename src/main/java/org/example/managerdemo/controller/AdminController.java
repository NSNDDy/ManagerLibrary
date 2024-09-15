package org.example.managerdemo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.managerdemo.dto.ApiResponse;
import org.example.managerdemo.dto.request.AdminRequest;
import org.example.managerdemo.dto.response.AdminResponse;
import org.example.managerdemo.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createAdmin(@Valid @RequestBody AdminRequest adminRequest){
        log.info("Admin request data : {}",adminRequest);

        adminService.createAdmin(adminRequest);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Tạo tài khoản này thành công", ""));
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<AdminResponse>>> getAllAdmin(){

        List<AdminResponse> adminrep = adminService.getAllAdmin();

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,"Danh sách tất cả tài khoản",adminrep));
    }

}
