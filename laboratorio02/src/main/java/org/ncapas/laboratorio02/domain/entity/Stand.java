package org.ncapas.laboratorio02.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idStand;

    @Column
    private String name;
}
