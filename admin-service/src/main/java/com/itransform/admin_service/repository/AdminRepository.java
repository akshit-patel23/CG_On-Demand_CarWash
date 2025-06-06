package com.itransform.admin_service.repository;

import com.itransform.admin_service.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin,UUID> {

}
