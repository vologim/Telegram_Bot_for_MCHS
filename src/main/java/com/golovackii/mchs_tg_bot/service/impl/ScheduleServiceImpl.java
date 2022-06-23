package com.golovackii.mchs_tg_bot.service.impl;

import com.golovackii.mchs_tg_bot.model.Document;
import com.golovackii.mchs_tg_bot.model.Schedule;
import com.golovackii.mchs_tg_bot.repository.ScheduleRepository;
import com.golovackii.mchs_tg_bot.service.ScheduleService;
import com.golovackii.mchs_tg_bot.util.FileLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final FileLoader fileLoader;
    private final String SCHEDULE_PATH = "Schedule/";

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, FileLoader fileLoader) {
        this.scheduleRepository = scheduleRepository;
        this.fileLoader = fileLoader;
    }

    @Override
    public void saveWithFile(Schedule schedule, MultipartFile multipartFile) {
        String path = fileLoader.uploadFile(SCHEDULE_PATH + schedule.getYear(), multipartFile);
        schedule.setDocument(new Document(path));
        scheduleRepository.save(schedule);
    }

    @Override
    public void updateWithFile(Schedule schedule, MultipartFile multipartFile) {
        String path = fileLoader.uploadFile(SCHEDULE_PATH + schedule.getYear(), multipartFile);
        schedule.setDocument(new Document(path));
        scheduleRepository.save(schedule);
    }

    @Override
    public Schedule getById(Integer id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Schedule> getList() {
        return scheduleRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        scheduleRepository.deleteById(id);
    }
}
