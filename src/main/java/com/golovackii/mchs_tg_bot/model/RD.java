package com.golovackii.mchs_tg_bot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Component
@Data
@Table(name = "rd")
public class RD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String nameDocument;

    @Column(name = "doc_date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate documentDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private Document document;

}
