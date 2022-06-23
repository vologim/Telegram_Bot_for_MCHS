package com.golovackii.mchs_tg_bot.service;

import com.golovackii.mchs_tg_bot.model.RD;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RDService {

    void saveWithFile(RD rd, MultipartFile multipartFile);

    void updateWithFile(RD rd, MultipartFile multipartFile);

    RD getById(Integer id);

    List<RD> getList();

    void deleteById(Integer id);
}

