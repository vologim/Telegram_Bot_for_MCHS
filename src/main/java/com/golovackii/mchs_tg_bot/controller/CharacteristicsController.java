package com.golovackii.mchs_tg_bot.controller;


import com.golovackii.mchs_tg_bot.model.Characteristics;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CharacteristicsController {

    Characteristics getById(Integer id);

    List<Characteristics> getListCharacteristics();

    void saveCharacteristics(String characteristics, MultipartFile multipartFile);

    void updateCharacteristics(String characteristics, MultipartFile multipartFile);

    void deleteCharacteristics(Integer id);
}
