package com.golovackii.mchs_tg_bot.service;

import com.golovackii.mchs_tg_bot.model.GarrisonService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GarrisonServiceService {

    void saveWithFile(GarrisonService garrisonService, MultipartFile multipartFile);

    void updateWithFile(GarrisonService garrisonService, MultipartFile multipartFile);

    GarrisonService getById(Integer id);

    List<GarrisonService> getList();

    void deleteById(Integer id);

}
