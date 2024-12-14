package com.example.msvoiture.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marque;
    private String matricule;
    private String model;

    private Long idClient; // Updated to camelCase

    @Transient
    private Client client; // Ignored by JPA, only used for response serialization
}
