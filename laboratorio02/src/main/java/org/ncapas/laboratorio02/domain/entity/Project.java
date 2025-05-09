package org.ncapas.laboratorio02.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idProject;

    @Column
    private String code;

    @Column
    private String name;

    @Column
    private Date entryDate;

    @OneToOne
    @JoinColumn(name = "id_area", nullable = false, foreignKey = @ForeignKey(name = "fk_area"))
    private Area area;

    @ManyToOne
    @JoinColumn(name = "id_costumer", nullable = false, foreignKey = @ForeignKey(name = "fk_costumer"))
    private Costumer costumer;
}
