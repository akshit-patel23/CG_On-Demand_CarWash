package com.itransform.washer_service.service.impl;

import com.itransform.washer_service.dto.WasherDto;
import com.itransform.washer_service.entity.Washer;
import com.itransform.washer_service.repository.WasherRepository;
import com.itransform.washer_service.service.WasherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class WasherServiceImpl implements WasherService {

    @Autowired
    public WasherRepository washerRepository;


    public WasherDto mapToDto(Washer washer){
        return new WasherDto(washer.getId(),washer.getName(),washer.getEmail(),washer.getPhone(),washer.getRole());
    }

    public Washer mapToEntity(WasherDto dto){
        Washer washer= new Washer();
        washer.setId(dto.getId());
        washer.setName(dto.getName());
        washer.setEmail(dto.getEmail());
        washer.setPhone(dto.getPhone());
        washer.setRole(dto.getRole());
        return washer;
    }
    @Override
    public WasherDto createWasher(WasherDto washerDto) {
        Washer washer=mapToEntity(washerDto);
        washer.setRole("washer");
        return mapToDto(washerRepository.save(washer));
    }

    @Override
    public WasherDto getWasherById(UUID id) {
        return washerRepository.findById(id).map(this::mapToDto)
                .orElseThrow(()->new RuntimeException("Washer Not Found"));
    }

    @Override
    public List<WasherDto> getAllWashers() {
        return washerRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public WasherDto updateWasher(UUID id, WasherDto dto) {
        return washerRepository.findById(id).map(existing->{
            existing.setName(dto.getName());
            existing.setEmail(dto.getEmail());
            existing.setPhone(dto.getPhone());

            return mapToDto(washerRepository.save(existing));

        }).orElse(null);
    }

    @Override
    public void deleteWasher(UUID id) {
        washerRepository.deleteById(id);
    }
}
