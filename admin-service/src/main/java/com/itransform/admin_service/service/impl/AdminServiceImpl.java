package com.itransform.admin_service.service.impl;

import com.itransform.admin_service.dto.AdminDto;
import com.itransform.admin_service.entity.Admin;
import com.itransform.admin_service.repository.AdminRepository;
import com.itransform.admin_service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    public AdminRepository adminRepository;

    public AdminDto mapToDto(Admin admin){
        return new AdminDto(admin.getId(),admin.getName(),admin.getEmail(),admin.getPhone(),admin.getRole());
    }

    public Admin mapToEntity(AdminDto dto){
        Admin admin= new Admin();
        admin.setId(dto.getId());
        admin.setName(dto.getName());
        admin.setEmail(dto.getEmail());
        admin.setPhone(dto.getPhone());
        admin.setRole(dto.getRole());
        return admin;
    }
    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin= mapToEntity(adminDto);
        admin.setRole("admin");
        return mapToDto(adminRepository.save(admin));
    }

    @Override
    public AdminDto getAdminById(UUID id) {
        return adminRepository.findById(id).map(this::mapToDto)
                .orElseThrow(()->new RuntimeException("Admin Not Found"));
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        return adminRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdminDto updateAdmin(UUID id, AdminDto dto) {
        return adminRepository.findById(id).map(existing->{
            existing.setName(dto.getName());
            existing.setEmail(dto.getEmail());
            existing.setPhone(dto.getPhone());
            return mapToDto(adminRepository.save(existing));
        }).orElse(null);
    }

    @Override
    public void deleteAdmin(UUID id) {
        adminRepository.deleteById(id);
    }
}
