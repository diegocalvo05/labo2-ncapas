package org.ncapas.laboratorio02.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projectXtecnology")
public class ProjectXTecnology {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProjectXTecnology;

    @ManyToOne
    @JoinColumn(name = "id_tecnology", nullable = false, foreignKey = @ForeignKey(name = "fk_tecnology"))
    private Tecnology tecnology;

    @ManyToOne
    @JoinColumn(name = "id_project", nullable = false, foreignKey = @ForeignKey(name = "fk_project"))
    private Project project;
}
