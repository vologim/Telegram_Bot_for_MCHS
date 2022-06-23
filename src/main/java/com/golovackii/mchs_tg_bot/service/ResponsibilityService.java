package com.golovackii.mchs_tg_bot.service;

import com.golovackii.mchs_tg_bot.model.Responsibility;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResponsibilityService {

    void saveWithFile(Responsibility responsibility, MultipartFile multipartFile);

    void updateWithFile(Responsibility responsibility, MultipartFile multipartFile);

    Responsibility getById(Integer id);

    List<Responsibility> getList();

    void deleteById(Integer id);
}
