package com.golovackii.mchs_tg_bot.repository;

import com.golovackii.mchs_tg_bot.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
