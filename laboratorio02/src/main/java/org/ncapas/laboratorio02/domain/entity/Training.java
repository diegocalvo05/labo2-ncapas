package org.ncapas.laboratorio02.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idTraining;

    @Column
    private String topic;

    @Column
    private Date date;

    @Column
    private Integer duration;

    @Column
    private String description;
}
