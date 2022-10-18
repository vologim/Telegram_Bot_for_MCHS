package com.golovackii.mchs_tg_bot.repository;


import com.golovackii.mchs_tg_bot.model.Characteristics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicsRepository extends JpaRepository<Characteristics, Integer> {
}
