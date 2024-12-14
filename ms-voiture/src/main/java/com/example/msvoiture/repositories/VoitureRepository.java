package com.example.msvoiture.repositories;

import com.example.msvoiture.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    List<Voiture> findByIdClient(Long idClient); // Matches the updated field name
}
