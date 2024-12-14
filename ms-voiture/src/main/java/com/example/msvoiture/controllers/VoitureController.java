package com.example.msvoiture.controllers;

import com.example.msvoiture.Services.ClientService;
import com.example.msvoiture.dto.VoitureDTO;
import com.example.msvoiture.entities.Client;
import com.example.msvoiture.entities.Voiture;
import com.example.msvoiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/voitures")
public class VoitureController {

    @Autowired
    private VoitureRepository voitureRepository;

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<Object> findAll() {
        try {
            List<Voiture> voitures = voitureRepository.findAll();

            // Convert Voiture to VoitureDTO
            List<VoitureDTO> voitureDTOs = voitures.stream().map(voiture -> {
                Client client = clientService.clientById(voiture.getIdClient()); // Fetch client by id_client
                return new VoitureDTO(
                        voiture.getId(),
                        voiture.getMarque(),
                        voiture.getMatricule(),
                        voiture.getModel(),
                        voiture.getIdClient(),
                        client
                );
            }).collect(Collectors.toList());

            return ResponseEntity.ok(voitureDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching voitures: " + e.getMessage());
        }
    }
    // Find Voiture by ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            Voiture voiture = voitureRepository.findById(id)
                    .orElseThrow(() -> new Exception("Voiture Introuvable"));

            // Fetch the client details using the ClientService
            voiture.setClient(clientService.clientById(voiture.getIdClient()));

            return ResponseEntity.ok(voiture);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Voiture not found with ID: " + id);
        }
    }

    // Find Voitures by Client ID
    @GetMapping("/client/{id}")
    public ResponseEntity<List<Voiture>> findByClient(@PathVariable Long id) {
        try {
            Client client = clientService.clientById(id);
            if (client != null) {
                List<Voiture> voitures = voitureRepository.findByIdClient(id);
                return ResponseEntity.ok(voitures);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Save Voiture
    @PostMapping("/{clientId}")
    public ResponseEntity<Object> save(@PathVariable Long clientId, @RequestBody Voiture voiture) {
        try {
            Client client = clientService.clientById(clientId);
            if (client != null) {
                // Set the fetched client in the voiture object
                voiture.setIdClient(clientId);
                voiture.setClient(client);

                // Save the Voiture with the associated Client
                Voiture savedVoiture = voitureRepository.save(voiture);

                return ResponseEntity.ok(savedVoiture);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Client not found with ID: " + clientId);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving voiture: " + e.getMessage());
        }
    }

    // Update Voiture
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Voiture updatedVoiture) {
        try {
            Voiture existingVoiture = voitureRepository.findById(id)
                    .orElseThrow(() -> new Exception("Voiture not found with ID: " + id));

            // Update only the non-null fields from the request body
            if (updatedVoiture.getMarque() != null && !updatedVoiture.getMarque().isEmpty()) {
                existingVoiture.setMarque(updatedVoiture.getMarque());
            }

            if (updatedVoiture.getMatricule() != null && !updatedVoiture.getMatricule().isEmpty()) {
                existingVoiture.setMatricule(updatedVoiture.getMatricule());
            }

            if (updatedVoiture.getModel() != null && !updatedVoiture.getModel().isEmpty()) {
                existingVoiture.setModel(updatedVoiture.getModel());
            }

            // Save the updated Voiture
            Voiture savedVoiture = voitureRepository.save(existingVoiture);

            return ResponseEntity.ok(savedVoiture);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating voiture: " + e.getMessage());
        }
    }
}
