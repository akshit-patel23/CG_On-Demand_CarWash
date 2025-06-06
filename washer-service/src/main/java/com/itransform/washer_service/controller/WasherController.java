package com.itransform.washer_service.controller;

import com.itransform.washer_service.dto.WasherDto;
import com.itransform.washer_service.service.WasherService;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/washers")
public class WasherController {

    private final WasherService washerService;

    public WasherController(WasherService washerService) {
        this.washerService = washerService;
    }


    @GetMapping
    public List<WasherDto> getAllWashers(){
        return washerService.getAllWashers();
    }

    @GetMapping("/{id}")
    public WasherDto getWasherById(@PathVariable UUID id){
        return washerService.getWasherById(id);
    }

    @PostMapping("/add")
    public WasherDto createWasher(@RequestBody WasherDto washerDto){
        return washerService.createWasher(washerDto);
    }

    @PutMapping("/update/{id}")
    public WasherDto updateWasher(@PathVariable UUID id,@RequestBody WasherDto washerDto){
        return washerService.updateWasher(id,washerDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteWasher(@PathVariable UUID id){
        washerService.deleteWasher(id);
        return "Washer Deleted Successfully";
    }
}
