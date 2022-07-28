package com.golovackii.mchs_tg_bot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "statistics")
@Data
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "click_count_RD")
    private Long clickCountRD;

    @Column(name = "click_count_schedule")
    private Long clickCountSchedule;

    @Column(name = "click_count_map_hydrant")
    private Long clickCountMapHydrant;

    @Column(name = "click_count_knowledge_base")
    private Long clickCountKnowledgeBase;

    @Column(name = "click_count_developer")
    private Long clickCountDeveloper;

    public void clickRD() {
        clickCountRD++;
    }

    public void clickSchedule() {
        clickCountSchedule++;
    }

    public void clickMapHydrant() {
        clickCountMapHydrant++;
    }

    public void clickKnowledgeBase() {
        clickCountKnowledgeBase++;
    }

    public void clickDeveloper() {
        clickCountDeveloper++;
    }
}
