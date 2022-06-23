package com.golovackii.mchs_tg_bot.controller;

import com.golovackii.mchs_tg_bot.model.Responsibility;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResponsibilityController {

    Responsibility getById(Integer id);

    List<Responsibility> getListResponsibilities();

    void saveResponsibility(String responsibility, MultipartFile multipartFile);

    void updateResponsibility(String responsibility, MultipartFile multipartFile);

    void deleteResponsibilityById(Integer id);
}
