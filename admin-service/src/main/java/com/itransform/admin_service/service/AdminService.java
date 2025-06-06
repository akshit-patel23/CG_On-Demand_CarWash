package com.itransform.admin_service.service;

import com.itransform.admin_service.dto.AdminDto;

import java.util.List;
import java.util.UUID;

public interface AdminService {
    AdminDto createAdmin(AdminDto dto);
    AdminDto getAdminById(UUID id);

    List<AdminDto>getAllAdmins();
    AdminDto updateAdmin(UUID id,AdminDto dto);
    void deleteAdmin(UUID id);
}
