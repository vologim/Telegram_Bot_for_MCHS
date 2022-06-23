package com.golovackii.mchs_tg_bot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
@Component
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "year")
    private String year;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private Document document;
}
