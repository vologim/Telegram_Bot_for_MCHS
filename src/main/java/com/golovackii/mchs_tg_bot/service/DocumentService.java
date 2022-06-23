package com.golovackii.mchs_tg_bot.service;

import com.golovackii.mchs_tg_bot.model.Document;

import java.util.List;

public interface DocumentService {

    void save(Document document);

    void update(Document document);

    Document getById(Long id);

    List<Document> getList();

    void deleteById(Long id);

}
