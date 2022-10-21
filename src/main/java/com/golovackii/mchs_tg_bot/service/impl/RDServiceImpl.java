package com.golovackii.mchs_tg_bot.service.impl;

import com.golovackii.mchs_tg_bot.model.Document;
import com.golovackii.mchs_tg_bot.model.RD;
import com.golovackii.mchs_tg_bot.repository.RDRepository;
import com.golovackii.mchs_tg_bot.service.RDService;
import com.golovackii.mchs_tg_bot.util.FileLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class RDServiceImpl implements RDService {

    private final RDRepository rdRepository;
    private final FileLoader fileLoader;

    @Autowired
    public RDServiceImpl(RDRepository rdRepository, FileLoader fileLoader) {
        this.rdRepository = rdRepository;
        this.fileLoader = fileLoader;
    }

    @Override
    public void saveWithFile(RD rd, MultipartFile multipartFile) {
        String path = fileLoader.uploadFile(rd.getNameDocument() + rd.getDocumentDate(), multipartFile);
        rd.setDocument(new Document(path));
        rd.setNameDocument(multipartFile.getOriginalFilename());
        rdRepository.save(rd);
    }

    @Override
    public void updateWithFile(RD rd, MultipartFile multipartFile) {
        String path = fileLoader.uploadFile(rd.getNameDocument() + rd.getDocumentDate(), multipartFile);
        rd.setDocument(new Document(path));
        rd.setNameDocument(multipartFile.getOriginalFilename());
        rdRepository.save(rd);
    }

    @Override
    public RD getById(Integer id) {
        return rdRepository.findById(id).orElse(null);
    }

    @Override
    public List<RD> getList() {
        return rdRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        rdRepository.deleteById(id);
    }
}