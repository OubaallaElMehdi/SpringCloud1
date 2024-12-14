package com.example.msvoiture.dto;

import com.example.msvoiture.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoitureDTO {
    private Long id;
    private String marque;
    private String matricule;
    private String model;
    private Long id_client;
    private Client client; // Include the client details in the response
}
