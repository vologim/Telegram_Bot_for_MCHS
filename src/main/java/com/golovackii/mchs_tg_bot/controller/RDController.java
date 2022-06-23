package com.golovackii.mchs_tg_bot.controller;

import com.golovackii.mchs_tg_bot.model.RD;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RDController {

    RD getRDById(Integer id);

    List<RD> getListRD();

    void saveRD(String rd, MultipartFile file);

    void updateRD(String rd, MultipartFile file);

    void deleteRDById(Integer id);

}
