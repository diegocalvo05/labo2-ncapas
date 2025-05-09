package org.ncapas.laboratorio02.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assessment_type")
public class AssessmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAssessmentType;

    @Column
    private String name;
}
