package com.golovackii.mchs_tg_bot.service;

import com.golovackii.mchs_tg_bot.model.Schedule;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ScheduleService {

    void saveWithFile(Schedule schedule, MultipartFile multipartFile);

    void updateWithFile(Schedule schedule, MultipartFile multipartFile);

    Schedule getById(Integer id);

    List<Schedule> getList();

    void deleteById(Integer id);
}
