package com.golovackii.mchs_tg_bot.service.impl;

import com.golovackii.mchs_tg_bot.model.Statistics;
import com.golovackii.mchs_tg_bot.repository.StatisticsRepository;
import com.golovackii.mchs_tg_bot.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final ApplicationContext context;
    private final StatisticsRepository statisticsRepository;
    private Statistics statistics;

    @Autowired
    public StatisticsServiceImpl(ApplicationContext context, StatisticsRepository statisticsRepository, Statistics statistics) {
        this.context = context;
        this.statisticsRepository = statisticsRepository;
        this.statistics = statistics;
    }

    @Override
    public void incrementCountByUserName(String userName, String className) {
        statistics = statisticsRepository.getByUserName(userName);

        if (statistics == null) {
            statistics = context.getBean("statistics", Statistics.class);
            statistics.setUserName(userName);
        }

        switch (className) {
            case ("GetScheduleByIdCommand"):
                statistics.clickSchedule();
                break;
            case ("GetResponsibilityByIdCommand"):
                statistics.clickKnowledgeBase();
                break;
            case ("GetRDByIdCommand"):
                statistics.clickRD();
                break;
            case ("GetMapHydrantByIdCommand"):
                statistics.clickMapHydrant();
                break;
            case ("ShowDeveloper"):
                statistics.clickDeveloper();
                break;
            case ("GetCharacteristicsDocument"):
                statistics.clickCharacteristicsDocument();
                break;
            default:
                break;
        }

        statistics.setRecentActivities(LocalDateTime.now());

        statisticsRepository.save(statistics);

    }
}
