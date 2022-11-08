package com.golovackii.mchs_tg_bot.service.impl;

import com.golovackii.mchs_tg_bot.model.Document;
import com.golovackii.mchs_tg_bot.model.GarrisonService;
import com.golovackii.mchs_tg_bot.repository.GarrisonServiceRepository;
import com.golovackii.mchs_tg_bot.service.GarrisonServiceService;
import com.golovackii.mchs_tg_bot.util.FileLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class GarrisonServiceServiceImpl implements GarrisonServiceService {

    private final GarrisonServiceRepository repository;
    private final FileLoader fileLoader;
    private final String GARRISON_SERVICE = "GarrisonService/";

    @Autowired
    public GarrisonServiceServiceImpl(GarrisonServiceRepository repository, FileLoader fileLoader) {
        this.repository = repository;
        this.fileLoader = fileLoader;
    }

    @Override
    public void saveWithFile(GarrisonService garrisonService, MultipartFile multipartFile) {
        String path = fileLoader.uploadFile(GARRISON_SERVICE + garrisonService.getFileName(), multipartFile);
        garrisonService.setDocument(new Document(path));
        garrisonService.setFileName(garrisonService.getFileName());
        repository.save(garrisonService);
    }

    @Override
    public void updateWithFile(GarrisonService garrisonService, MultipartFile multipartFile) {
        String path = fileLoader.uploadFile(GARRISON_SERVICE + garrisonService.getFileName(), multipartFile);
        garrisonService.setDocument(new Document(path));
        garrisonService.setFileName(garrisonService.getFileName());
        repository.save(garrisonService);
    }

    @Override
    public GarrisonService getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<GarrisonService> getList() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
