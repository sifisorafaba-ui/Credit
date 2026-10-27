package com.creditapplication.creditapplication.controller;

import com.creditapplication.creditapplication.entity.Client;
import com.creditapplication.creditapplication.service.ClientService;

import com.creditapplication.creditapplication.dto.ClientRequestDTO;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody ClientRequestDTO request){

        Client savedClient = clientService.createClient(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedClient);
    }

    @GetMapping
    public List<Client> findAllClients(){
        return clientService.findAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findClientById(@PathVariable Long id) {

        Client client = clientService.findClientById(id);

        return ResponseEntity.ok(client);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(
            @PathVariable Long id,
            @Valid @RequestBody ClientRequestDTO request) {

        Client updatedClient = clientService.updateClient(id, request);

        return ResponseEntity.ok(updatedClient);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {

        clientService.deleteClient(id);

        return ResponseEntity.noContent().build();
    }

}
