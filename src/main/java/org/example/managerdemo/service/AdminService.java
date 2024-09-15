package org.example.managerdemo.service;

import org.example.managerdemo.dto.request.AdminRequest;
import org.example.managerdemo.dto.response.AdminResponse;

import java.util.List;

public interface AdminService {

    void createAdmin(AdminRequest adminreq);

    List<AdminResponse> getAllAdmin();

    AdminResponse getAdminById(Integer id);

    AdminResponse updateAdmin(Integer id, AdminRequest adminreq);

    void deleteAdmin(Integer id);

}
