package com.creditapplication.creditapplication.controller;

import com.creditapplication.creditapplication.entity.Client;
import com.creditapplication.creditapplication.service.ClientService;

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
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clientService.createClient(client));
    }

    @GetMapping
    public List<Client> findAllClients(){
        return clientService.findAllClients();
    }
}
