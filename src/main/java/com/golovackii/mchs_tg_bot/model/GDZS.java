package com.golovackii.mchs_tg_bot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Data
@Table(name = "GDZS")
@Entity
public class GDZS {

    @Id
    private int id;

    @Column(name = "file_name")
    private String fileName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private Document document;
}
