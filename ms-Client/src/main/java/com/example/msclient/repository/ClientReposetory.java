

package com.example.msclient.repository;

import com.example.msclient.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientReposetory extends JpaRepository<Client, Long> {
}
