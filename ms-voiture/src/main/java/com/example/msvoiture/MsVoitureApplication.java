package com.example.msvoiture;

import com.example.msvoiture.Services.ClientService;
import com.example.msvoiture.entities.Client;
import com.example.msvoiture.entities.Voiture;
import com.example.msvoiture.repositories.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class MsVoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsVoitureApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService) {
        return args -> {
            Client c1 = clientService.clientById(2L);
            Client c2 = clientService.clientById(1L);

            voitureRepository.save(new Voiture(null, "Reanault", "a1 78 77", "Dacia", c1.getId(), c2));
            voitureRepository.save(new Voiture(null, "Volwevagen", "Method... ", "stepway", c2.getId(), c2));
            voitureRepository.save(new Voiture(null, "docker", "77 77 77", "Corolla1", c1.getId(), c2));
        };
    }

}
