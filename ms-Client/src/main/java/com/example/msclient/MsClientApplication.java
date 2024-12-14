package com.example.msclient;

import com.example.msclient.entity.Client;
import com.example.msclient.repository.ClientReposetory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
@EnableDiscoveryClient
@SpringBootApplication
public class MsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsClientApplication.class, args);
    }


    @Bean
    CommandLineRunner initialiserBaseH2(ClientReposetory clientReposetory) {
        return args -> {
            clientReposetory.save(new Client(null, "Zouizza ", 10f));
            clientReposetory.save(new Client(null, "Mohmed ", 85f));
            clientReposetory.save(new Client(null, "Khalol ", 20f));
        };
    }
}
