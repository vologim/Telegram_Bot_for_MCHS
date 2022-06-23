package com.golovackii.mchs_tg_bot.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.golovackii.mchs_tg_bot.controller.RDController;
import com.golovackii.mchs_tg_bot.model.RD;
import com.golovackii.mchs_tg_bot.service.RDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/rd")
public class RDControllerImpl implements RDController {

    private final RDService rdService;

    @Autowired
    public RDControllerImpl(RDService rdService) {
        this.rdService = rdService;
    }

    @Override
    @GetMapping("/{id}")
    public RD getRDById(@PathVariable Integer id) {
        return rdService.getById(id);
    }

    @Override
    @GetMapping
    public List<RD> getListRD() {
        return rdService.getList();
    }

    @Override
    @PostMapping
    public void saveRD(@RequestParam(name = "rd") String rd, @RequestParam(name = "file") MultipartFile file) {

        ObjectMapper objectMapper = new ObjectMapper();
        RD newRD = null;
        try {
            newRD = objectMapper.readValue(rd, RD.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        rdService.saveWithFile(newRD, file);
    }

    @Override
    @PutMapping
    public void updateRD(@RequestParam(name = "rd") String rd, @RequestParam(name = "file") MultipartFile file) {

        ObjectMapper objectMapper = new ObjectMapper();
        RD newRD = null;
        try {
            newRD = objectMapper.readValue(rd, RD.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (newRD.getId() == null) {
            rdService.saveWithFile(newRD, file);
        }
        rdService.updateWithFile(newRD, file);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteRDById(@PathVariable Integer id) {
        rdService.deleteById(id);
    }

}
