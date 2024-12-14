package com.example.msclient.ws;
import com.example.msclient.entity.Client;
import com.example.msclient.repository.ClientReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientReposetory clientReposetory;

    @GetMapping("/clients")
    public List<Client> findAll() {
        return clientReposetory.findAll();
    }

    @GetMapping("/client/{id}")
    public Client findById(@PathVariable Long id) throws Exception {
        return clientReposetory.findById(id)
                .orElseThrow(() -> new Exception("Client not found"));
    }
}
