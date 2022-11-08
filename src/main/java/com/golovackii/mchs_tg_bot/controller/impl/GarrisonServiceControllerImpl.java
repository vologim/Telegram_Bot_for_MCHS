package com.golovackii.mchs_tg_bot.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.golovackii.mchs_tg_bot.controller.GarrisonServiceController;
import com.golovackii.mchs_tg_bot.model.GarrisonService;
import com.golovackii.mchs_tg_bot.service.GarrisonServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/garrisonService")
public class GarrisonServiceControllerImpl implements GarrisonServiceController {

    private final GarrisonServiceService service;

    @Autowired
    public GarrisonServiceControllerImpl(GarrisonServiceService service) {
        this.service = service;
    }

    @Override
    @GetMapping("/{id}")
    public GarrisonService getGarrisonServiceById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @Override
    @GetMapping
    public List<GarrisonService> getListGarrisonService() {
        return service.getList();
    }

    @Override
    @PostMapping
    public void saveGarrisonService(@RequestParam(name = "garrisonService") String garrisonService, @RequestParam(name = "file") MultipartFile file) {

        ObjectMapper objectMapper = new ObjectMapper();
        GarrisonService newGarrisonService = null;
        try {
            newGarrisonService = objectMapper.readValue(garrisonService, GarrisonService.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        service.saveWithFile(newGarrisonService, file);
    }

    @Override
    @PutMapping
    public void updateGarrisonService(@RequestParam(name = "garrisonService") String garrisonService, @RequestParam(name = "file") MultipartFile file) {

        ObjectMapper objectMapper = new ObjectMapper();
        GarrisonService newGarrisonService = null;
        try {
            newGarrisonService = objectMapper.readValue(garrisonService, GarrisonService.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        service.updateWithFile(newGarrisonService, file);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteGarrisonServiceById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
