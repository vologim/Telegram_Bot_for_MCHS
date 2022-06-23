package com.golovackii.mchs_tg_bot.controller;

import com.golovackii.mchs_tg_bot.model.Schedule;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ScheduleController {

    Schedule getById(Integer id);

    List<Schedule> getListSchedules();

    void saveSchedule(String schedule, MultipartFile multipartFile);

    void updateSchedule(String schedule, MultipartFile multipartFile);

    void deleteScheduleById(Integer id);
}
