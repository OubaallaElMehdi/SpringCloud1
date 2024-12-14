package com.example.msvoiture.Services;

import com.example.msvoiture.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MS-CLIENT")
public interface ClientService {
    @GetMapping(path = "/client/{id}")
    Client clientById(@PathVariable Long id);
}
