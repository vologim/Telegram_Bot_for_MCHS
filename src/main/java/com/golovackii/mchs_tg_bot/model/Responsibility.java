package com.golovackii.mchs_tg_bot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Data
@Table(name = "responsibilities")
public class Responsibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "position")
    private String position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private Document document;
}
