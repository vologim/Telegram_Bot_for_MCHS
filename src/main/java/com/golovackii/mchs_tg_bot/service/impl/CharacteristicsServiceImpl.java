package com.golovackii.mchs_tg_bot.service.impl;

import com.golovackii.mchs_tg_bot.model.Characteristics;
import com.golovackii.mchs_tg_bot.model.Document;
import com.golovackii.mchs_tg_bot.repository.CharacteristicsRepository;
import com.golovackii.mchs_tg_bot.service.CharacteristicsService;
import com.golovackii.mchs_tg_bot.util.FileLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CharacteristicsServiceImpl implements CharacteristicsService {

    private final CharacteristicsRepository characteristicsRepository;
    private final FileLoader fileLoader;
    private final String CHARACTERISTICS_PATH = "Characteristics/";

    @Autowired
    public CharacteristicsServiceImpl(CharacteristicsRepository characteristicsRepository, FileLoader fileLoader) {
        this.characteristicsRepository = characteristicsRepository;
        this.fileLoader = fileLoader;
    }

    @Override
    public void saveWithFile(Characteristics characteristics, MultipartFile multipartFile) {
        String path = fileLoader.uploadFile(CHARACTERISTICS_PATH + characteristics.getFileName(), multipartFile);
        characteristics.setDocument(new Document(path));
        characteristics.setFileName(multipartFile.getOriginalFilename());
        characteristicsRepository.save(characteristics);
    }

    @Override
    public void updateWithFile(Characteristics characteristics, MultipartFile multipartFile) {
        String path = fileLoader.uploadFile(CHARACTERISTICS_PATH + characteristics.getFileName(), multipartFile);
        characteristics.setDocument(new Document(path));
        characteristics.setFileName(multipartFile.getOriginalFilename());
        characteristicsRepository.save(characteristics);
    }

    @Override
    public Characteristics getById(Integer id) {
        return characteristicsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Characteristics> getList() {
        return characteristicsRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        characteristicsRepository.deleteById(id);
    }
}
