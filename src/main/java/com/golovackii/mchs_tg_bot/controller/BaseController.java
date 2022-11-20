package com.golovackii.mchs_tg_bot.controller;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BaseController<T> {

    T getElementById(Integer id);

    List<T> getListElements();

    void saveElementWithFile(String element, MultipartFile file);

    void updateElementWithFile(String element, MultipartFile file);

    void deleteElementById(Integer id);
}
