package com.golovackii.mchs_tg_bot.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BaseService<T> {

    void saveWithFile(T element, MultipartFile multipartFile);

    void updateWithFile(T element, MultipartFile multipartFile);

    T getById(Integer id);

    List<T> getList();

    void deleteById(Integer id);

}
