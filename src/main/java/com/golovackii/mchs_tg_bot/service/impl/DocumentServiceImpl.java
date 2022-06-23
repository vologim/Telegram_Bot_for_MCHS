package com.golovackii.mchs_tg_bot.service.impl;

import com.golovackii.mchs_tg_bot.model.Document;
import com.golovackii.mchs_tg_bot.repository.DocumentRepository;
import com.golovackii.mchs_tg_bot.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public void save(Document document) {
        documentRepository.save(document);
    }

    @Override
    public void update(Document document) {
        documentRepository.save(document);
    }

    @Override
    public Document getById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Document> getList() {
        return documentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        documentRepository.deleteById(id);
    }
}
