package com.golovackii.mchs_tg_bot.service.impl;

import com.golovackii.mchs_tg_bot.model.Document;
import com.golovackii.mchs_tg_bot.model.GDZS;
import com.golovackii.mchs_tg_bot.repository.GDZSRepository;
import com.golovackii.mchs_tg_bot.service.GDZSService;
import com.golovackii.mchs_tg_bot.util.FileLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class GDZSServiceImpl implements GDZSService {

    private final GDZSRepository gdzsRepository;
    private final FileLoader fileLoader;
    private final String PATH = "GDZS/";

    @Autowired
    public GDZSServiceImpl(GDZSRepository gdzsRepository, FileLoader fileLoader) {
        this.gdzsRepository = gdzsRepository;
        this.fileLoader = fileLoader;
    }

    @Override
    public void saveWithFile(GDZS element, MultipartFile multipartFile) {
        String path = fileLoader.uploadFile(PATH + element.getFileName(), multipartFile);
        element.setDocument(new Document(path));
        element.setFileName(element.getFileName());
        gdzsRepository.save(element);
    }

    @Override
    public void updateWithFile(GDZS element, MultipartFile multipartFile) {
        String path = fileLoader.uploadFile(PATH + element.getFileName(), multipartFile);
        element.setDocument(new Document(path));
        element.setFileName(element.getFileName());
        gdzsRepository.save(element);
    }

    @Override
    public GDZS getById(Integer id) {
        return gdzsRepository.findById(id).orElse(null);
    }

    @Override
    public List<GDZS> getList() {
        return gdzsRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        gdzsRepository.deleteById(id);
    }
}
