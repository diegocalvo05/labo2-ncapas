package org.ncapas.laboratorio02.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "area_category")
public class AreaCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAreaCategory;

    @Column
    private String name;
}
