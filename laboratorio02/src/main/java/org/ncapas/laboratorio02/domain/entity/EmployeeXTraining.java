package org.ncapas.laboratorio02.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employeeXtraining")
public class EmployeeXTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEmployeeXTraining;

    @ManyToOne
    @JoinColumn(name = "id_training", nullable = false, foreignKey = @ForeignKey(name = "fk_training"))
    private Training idTraining;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false, foreignKey = @ForeignKey(name = "fk_employee"))
    private Employee idEmployee;
}
