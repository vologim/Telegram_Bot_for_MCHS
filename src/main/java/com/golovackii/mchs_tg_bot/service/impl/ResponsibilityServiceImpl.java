package com.golovackii.mchs_tg_bot.service.impl;

import com.golovackii.mchs_tg_bot.model.Document;
import com.golovackii.mchs_tg_bot.model.Responsibility;
import com.golovackii.mchs_tg_bot.repository.ResponsibilityRepository;
import com.golovackii.mchs_tg_bot.service.ResponsibilityService;
import com.golovackii.mchs_tg_bot.util.FileLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ResponsibilityServiceImpl implements ResponsibilityService {

    private final ResponsibilityRepository responsibilityRepository;
    private final FileLoader fileLoader;
    private final String RESPONSIBILITY_PATH = "Responsibility/";

    @Autowired
    public ResponsibilityServiceImpl(ResponsibilityRepository responsibilityRepository, FileLoader fileLoader) {
        this.responsibilityRepository = responsibilityRepository;
        this.fileLoader = fileLoader;
    }

    @Override
    public void saveWithFile(Responsibility responsibility, MultipartFile multipartFile) {
        String path = fileLoader.uploadFile(RESPONSIBILITY_PATH + responsibility.getPosition(), multipartFile);
        responsibility.setDocument(new Document(path));
        responsibilityRepository.save(responsibility);
    }

    @Override
    public void updateWithFile(Responsibility responsibility, MultipartFile multipartFile) {
        String path = fileLoader.uploadFile(RESPONSIBILITY_PATH + responsibility.getPosition(), multipartFile);
        responsibility.setDocument(new Document(path));
        responsibilityRepository.save(responsibility);
    }

    @Override
    public Responsibility getById(Integer id) {
        return responsibilityRepository.findById(id).orElse(null);
    }

    @Override
    public List<Responsibility> getList() {
        return responsibilityRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        responsibilityRepository.deleteById(id);
    }
}
