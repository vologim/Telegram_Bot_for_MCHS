package com.golovackii.mchs_tg_bot.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.golovackii.mchs_tg_bot.controller.ResponsibilityController;
import com.golovackii.mchs_tg_bot.model.Responsibility;
import com.golovackii.mchs_tg_bot.service.ResponsibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/responsibility")
public class ResponsibilityControllerImpl implements ResponsibilityController {

    private final ResponsibilityService responsibilityService;

    @Autowired
    public ResponsibilityControllerImpl(ResponsibilityService responsibilityService) {
        this.responsibilityService = responsibilityService;
    }

    @Override
    @GetMapping("/{id}")
    public Responsibility getElementById(@PathVariable Integer id) {
        return responsibilityService.getById(id);
    }

    @Override
    @GetMapping
    public List<Responsibility> getListElements() {
        return responsibilityService.getList();
    }

    @Override
    @PostMapping
    public void saveElementWithFile(@RequestParam(name = "responsibility") String responsibility, @RequestParam(name = "file") MultipartFile multipartFile) {

        ObjectMapper objectMapper = new ObjectMapper();
        Responsibility newResponsibility = null;
        try {
            newResponsibility = objectMapper.readValue(responsibility, Responsibility.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        responsibilityService.saveWithFile(newResponsibility, multipartFile);
    }

    @Override
    @PutMapping
    public void updateElementWithFile(@RequestParam(name = "responsibility") String responsibility, @RequestParam(name = "file") MultipartFile multipartFile) {

        ObjectMapper objectMapper = new ObjectMapper();
        Responsibility newResponsibility = null;
        try {
            newResponsibility = objectMapper.readValue(responsibility, Responsibility.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        responsibilityService.updateWithFile(newResponsibility, multipartFile);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteElementById(@PathVariable Integer id) {
        responsibilityService.getById(id);
    }
}
