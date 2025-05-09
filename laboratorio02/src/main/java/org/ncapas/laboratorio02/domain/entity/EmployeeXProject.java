package org.ncapas.laboratorio02.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employeeXproject")
public class EmployeeXProject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEmployeeXProject;

    @Column
    private Date entryDate;

    @ManyToOne
    @JoinColumn(name = "id_employee_type", nullable = false, foreignKey = @ForeignKey(name = "fk_employee_type"))
    private EmployeeType employeeType;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false, foreignKey = @ForeignKey(name = "fk_employee"))
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_project", nullable = false, foreignKey = @ForeignKey(name = "fk_employeeXproject"))
    private Project project;
}
