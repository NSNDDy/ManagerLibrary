package org.example.managerdemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.managerdemo.dto.request.AdminRequest;
import org.example.managerdemo.dto.response.AdminResponse;
import org.example.managerdemo.entity.Admin;
import org.example.managerdemo.entity.User;
import org.example.managerdemo.exception.ResourceNotFoundException;
import org.example.managerdemo.repository.AdminRepository;
import org.example.managerdemo.repository.UserRepository;
import org.example.managerdemo.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    @Override
    public void createAdmin(AdminRequest adminreq) {
        /*validateAdminRequest(adminreq);*/

        User user = userRepository.findById(adminreq.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User ID not found!"));


        Admin admin = new Admin();

        admin.setUser(user);
        admin.setRole(adminreq.getRole());

        adminRepository.save(admin);
    }

    @Override
    public List<AdminResponse> getAllAdmin() {
        List<Admin> admins = adminRepository.findAll();

        return admins.stream()
                .map(admin -> new AdminResponse(
                        admin.getId()
                        , admin.getUser().getUserId()
                        , admin.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public AdminResponse getAdminById(Integer id) {

        return adminRepository.findById(id)
                .map(admin -> new AdminResponse(admin.getId()
                        , admin.getUser().getUserId()
                        , admin.getRole())).orElseThrow(() -> new ResourceNotFoundException("Admin not found!"));
    }

    @Override
    public AdminResponse updateAdmin(Integer id, AdminRequest adminreq) {
        validateAdminRequest(adminreq);

        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id Admin not found!"));

        admin.setUser(userRepository.findById(adminreq.getUserId()).get());
        admin.setRole(adminreq.getRole());

        adminRepository.save(admin);

        return new AdminResponse(admin.getId(), admin.getUser().getUserId(), admin.getRole());
    }

    @Override
    public void deleteAdmin(Integer id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id Admin not found!"));
        adminRepository.delete(admin);

    }

    private void validateAdminRequest(AdminRequest adminRequest) {

    }
}
