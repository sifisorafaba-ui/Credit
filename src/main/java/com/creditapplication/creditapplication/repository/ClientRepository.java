package com.creditapplication.creditapplication.repository;

import com.creditapplication.creditapplication.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
