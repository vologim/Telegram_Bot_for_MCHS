package com.golovackii.mchs_tg_bot.service;

import com.golovackii.mchs_tg_bot.model.Characteristics;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CharacteristicsService {

    void saveWithFile(Characteristics characteristics, MultipartFile multipartFile);

    void updateWithFile(Characteristics characteristics, MultipartFile multipartFile);

    Characteristics getById(Integer id);

    List<Characteristics> getList();

    void deleteById(Integer id);
}
