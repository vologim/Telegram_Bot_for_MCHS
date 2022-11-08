package com.golovackii.mchs_tg_bot.controller;

import com.golovackii.mchs_tg_bot.model.GarrisonService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GarrisonServiceController {

    GarrisonService getGarrisonServiceById(Integer id);

    List<GarrisonService> getListGarrisonService();

    void saveGarrisonService(String garrisonService, MultipartFile file);

    void updateGarrisonService(String garrisonService, MultipartFile file);

    void deleteGarrisonServiceById(Integer id);

}
