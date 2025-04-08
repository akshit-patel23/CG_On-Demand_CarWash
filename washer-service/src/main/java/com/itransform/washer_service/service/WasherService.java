package com.itransform.washer_service.service;

import com.itransform.washer_service.dto.WasherDto;

import java.util.List;
import java.util.UUID;

public interface WasherService {
    WasherDto createWasher(WasherDto dto);
    WasherDto getWasherById(UUID id);
   List <WasherDto> getAllWashers();

   WasherDto updateWasher(UUID id,WasherDto dto);

   void deleteWasher(UUID id);

}
