package org.ncapas.laboratorio02.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idArea;

    @Column
    private Float price;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_area_category", nullable = false, foreignKey = @ForeignKey(name = "fk_area_category"))
    private AreaCategory areaCategory;
}
