package com.golovackii.mchs_tg_bot.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.golovackii.mchs_tg_bot.controller.ScheduleController;
import com.golovackii.mchs_tg_bot.model.Schedule;
import com.golovackii.mchs_tg_bot.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleControllerImpl implements ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleControllerImpl(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @Override
    @GetMapping("/{id}")
    public Schedule getElementById(@PathVariable Integer id) {
        return scheduleService.getById(id);
    }

    @Override
    @GetMapping
    public List<Schedule> getListElements() {
        return scheduleService.getList();
    }

    @Override
    @PostMapping
    public void saveElementWithFile(@RequestParam(name = "schedule") String schedule, @RequestParam(name = "file") MultipartFile multipartFile) {

        ObjectMapper objectMapper = new ObjectMapper();
        Schedule newSchedule = null;
        try {
            newSchedule = objectMapper.readValue(schedule, Schedule.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        scheduleService.saveWithFile(newSchedule, multipartFile);
    }

    @Override
    @PutMapping
    public void updateElementWithFile(@RequestParam(name = "schedule") String schedule, @RequestParam(name = "file") MultipartFile multipartFile) {

        ObjectMapper objectMapper = new ObjectMapper();
        Schedule newSchedule = null;
        try {
            newSchedule = objectMapper.readValue(schedule, Schedule.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (newSchedule.getId() == null) {
            scheduleService.saveWithFile(newSchedule, multipartFile);
        }
        scheduleService.updateWithFile(newSchedule, multipartFile);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteElementById(@PathVariable Integer id) {
        scheduleService.deleteById(id);
    }
}
