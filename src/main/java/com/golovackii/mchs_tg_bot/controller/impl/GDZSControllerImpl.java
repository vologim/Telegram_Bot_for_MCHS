package com.golovackii.mchs_tg_bot.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.golovackii.mchs_tg_bot.controller.GDZSController;
import com.golovackii.mchs_tg_bot.model.GDZS;
import com.golovackii.mchs_tg_bot.service.GDZSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/gdzs")
public class GDZSControllerImpl implements GDZSController {

    private final GDZSService gdzsService;

    @Autowired
    public GDZSControllerImpl(GDZSService gdzsService) {
        this.gdzsService = gdzsService;
    }

    @Override
    @GetMapping("/{id}")
    public GDZS getElementById(@PathVariable Integer id) {
        return gdzsService.getById(id);
    }

    @Override
    @GetMapping
    public List<GDZS> getListElements() {
        return gdzsService.getList();
    }

    @Override
    @PostMapping
    public void saveElementWithFile(@RequestParam(name = "gdzs") String element, @RequestParam(name = "file") MultipartFile file) {

        ObjectMapper objectMapper = new ObjectMapper();
        GDZS gdzs = null;
        try {
            gdzs = objectMapper.readValue(element, GDZS.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        gdzsService.saveWithFile(gdzs, file);

    }

    @Override
    @PutMapping
    public void updateElementWithFile(@RequestParam(name = "gdzs") String element, @RequestParam(name = "file") MultipartFile file) {

        ObjectMapper objectMapper = new ObjectMapper();
        GDZS gdzs = null;
        try {
            gdzs = objectMapper.readValue(element, GDZS.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        gdzsService.updateWithFile(gdzs, file);

    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteElementById(@PathVariable(name = "id") Integer id) {
        gdzsService.deleteById(id);
    }
}
