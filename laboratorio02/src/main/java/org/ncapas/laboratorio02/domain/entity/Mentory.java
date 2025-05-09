package org.ncapas.laboratorio02.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mentory")
public class Mentory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMentory;

    @ManyToOne
    @JoinColumn(name = "id_mentor", nullable = false, foreignKey = @ForeignKey(name = "fk_mentor"))
    private Employee mentor;

    @ManyToOne
    @JoinColumn(name = "id_mentored", nullable = false, foreignKey = @ForeignKey(name = "fk_mentored"))
    private Employee mentored;

    @Column
    private Integer time;

    private String description;
}
