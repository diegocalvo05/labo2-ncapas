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
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idEmployee;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "id_department", nullable = false, foreignKey = @ForeignKey(name = "fk_department"))
    private Department department;
}
