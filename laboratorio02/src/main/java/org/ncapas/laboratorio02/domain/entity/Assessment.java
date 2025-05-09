package org.ncapas.laboratorio02.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assessment")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idAssessment;

    @Column
    private Integer quantification;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "id_training", nullable = false, foreignKey = @ForeignKey(name = "fk_training"))
    private Training training;

    @ManyToOne
    @JoinColumn(name = "id_assessment_type", nullable = false, foreignKey = @ForeignKey(name = "fk_assessment_type"))
    private AssessmentType assessmentType;
}

