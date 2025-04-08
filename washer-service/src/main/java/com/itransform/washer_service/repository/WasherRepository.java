package com.itransform.washer_service.repository;

import com.itransform.washer_service.entity.Washer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WasherRepository extends JpaRepository<Washer, UUID> {

}
