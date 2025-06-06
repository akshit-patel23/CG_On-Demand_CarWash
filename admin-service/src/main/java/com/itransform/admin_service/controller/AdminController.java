package com.itransform.admin_service.controller;

import com.itransform.admin_service.dto.AdminDto;
import com.itransform.admin_service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<AdminDto> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public AdminDto getAdminById(@PathVariable UUID id){
        return adminService.getAdminById(id);
    }

    @PostMapping("/add")
    public AdminDto createAdmin(@RequestBody AdminDto adminDto){
        return adminService.createAdmin(adminDto);
    }

    @PutMapping("/update/{id}")
    public AdminDto updateAdmin(@PathVariable UUID id,@RequestBody AdminDto dto){
        return adminService.updateAdmin(id,dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable UUID id){
        adminService.deleteAdmin(id);
        return "Admin Deleted Successfully";
    }
}
