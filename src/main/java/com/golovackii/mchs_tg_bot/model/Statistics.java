package com.golovackii.mchs_tg_bot.model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Component
@Scope(value = "prototype")
@Table(name = "statistics")
@Data
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "click_count_RD")
    private Long clickCountRD;

    @Column(name = "click_count_schedule")
    private Long clickCountSchedule;

    @Column(name = "click_count_map_hydrant")
    private Long clickCountMapHydrant;

    @Column(name = "click_count_responsibility")
    private Long clickResponsibility;

    @Column(name = "click_count_developer")
    private Long clickCountDeveloper;

    @Column(name = "click_characteristics")
    private Long clickCharacteristics;

    @Column(name = "recent_activities")
    private LocalDateTime recentActivities;

    @Column(name = "click_garrison_service")
    private Long clickGarrisonService;

    public Statistics() {
        this.clickCountRD = 0L;
        this.clickCountSchedule = 0L;
        this.clickCountMapHydrant = 0L;
        this.clickResponsibility = 0L;
        this.clickCountDeveloper = 0L;
        this.clickCharacteristics = 0L;
        this.recentActivities = LocalDateTime.of(1993, 11, 9, 17, 35);
        this.clickGarrisonService = 0L;
    }

    public void clickRD() {
        clickCountRD++;
    }

    public void clickSchedule() {
        clickCountSchedule++;
    }

    public void clickMapHydrant() {
        clickCountMapHydrant++;
    }

    public void clickResponsibility() {
        clickResponsibility++;
    }

    public void clickDeveloper() {
        clickCountDeveloper++;
    }

    public void clickCharacteristics() {
        clickCharacteristics++;
    }

    public void clickGarrisonService() {
        clickGarrisonService++;
    }
}
