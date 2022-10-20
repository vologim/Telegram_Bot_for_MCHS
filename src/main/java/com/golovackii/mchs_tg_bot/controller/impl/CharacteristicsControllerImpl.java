package com.golovackii.mchs_tg_bot.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.golovackii.mchs_tg_bot.controller.CharacteristicsController;
import com.golovackii.mchs_tg_bot.model.Characteristics;
import com.golovackii.mchs_tg_bot.service.CharacteristicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/characteristics")
public class CharacteristicsControllerImpl implements CharacteristicsController {

    private final CharacteristicsService characteristicsService;

    @Autowired
    public CharacteristicsControllerImpl(CharacteristicsService characteristicsService) {
        this.characteristicsService = characteristicsService;
    }

    @Override
    @GetMapping("/{id}")
    public Characteristics getById(@PathVariable Integer id) {
        return characteristicsService.getById(id);
    }

    @Override
    @GetMapping
    public List<Characteristics> getListCharacteristics() {
        return characteristicsService.getList();
    }

    @Override
    @PostMapping
    public void saveCharacteristics(@RequestParam(name = "characteristics") String characteristics, @RequestParam(name = "file") MultipartFile multipartFile) {

        ObjectMapper objectMapper = new ObjectMapper();
        Characteristics newCharacteristics = null;
        try {
            newCharacteristics = objectMapper.readValue(characteristics, Characteristics.class);
            newCharacteristics.setFileName(multipartFile.getOriginalFilename());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        characteristicsService.saveWithFile(newCharacteristics, multipartFile);
    }

    @Override
    @PutMapping
    public void updateCharacteristics(@RequestParam(name = "characteristics") String characteristics, @RequestParam(name = "file") MultipartFile multipartFile) {

        ObjectMapper objectMapper = new ObjectMapper();
        Characteristics newCharacteristics = null;
        try {
            newCharacteristics = objectMapper.readValue(characteristics, Characteristics.class);
            newCharacteristics.setFileName(multipartFile.getOriginalFilename());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        characteristicsService.updateWithFile(newCharacteristics, multipartFile);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteCharacteristics(@PathVariable Integer id) {
        characteristicsService.deleteById(id);
    }
}