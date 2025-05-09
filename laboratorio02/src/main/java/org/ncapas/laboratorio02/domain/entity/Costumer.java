package org.ncapas.laboratorio02.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "costumer")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idCostumer;

    @Column
    private String name;

    @Column
    private String industry;

    @OneToOne
    @JoinColumn(name = "id_contact", nullable = false, foreignKey = @ForeignKey(name = "fk_contact"))
    private Contact contact;
}
