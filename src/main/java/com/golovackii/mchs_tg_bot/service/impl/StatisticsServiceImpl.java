package com.golovackii.mchs_tg_bot.service.impl;

import com.golovackii.mchs_tg_bot.model.Statistics;
import com.golovackii.mchs_tg_bot.repository.StatisticsRepository;
import com.golovackii.mchs_tg_bot.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsServiceImpl(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public void incrementCountByUserName(String userName, String className) {
        Statistics statistics = statisticsRepository.getByUserName(userName);
    }
}
