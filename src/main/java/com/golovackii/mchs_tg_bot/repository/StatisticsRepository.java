package com.golovackii.mchs_tg_bot.repository;

import com.golovackii.mchs_tg_bot.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

    Statistics getByUserName(String userName);

}
