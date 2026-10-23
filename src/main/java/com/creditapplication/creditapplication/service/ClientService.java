package com.creditapplication.creditapplication.service;

import com.creditapplication.creditapplication.entity.Client;
import com.creditapplication.creditapplication.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }
    public Optional findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Optional<Client> updateClient(Long id, Client updatedClient) {
        return clientRepository.findById(id).map(client -> {
            client.setFirstName(updatedClient.getFirstName());
            client.setLastName(updatedClient.getLastName());
            client.setEmployer(updatedClient.getEmployer());

            return clientRepository.save(client);
        });
    }

    public boolean deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            return false;
        }
        clientRepository.deleteById(id);
        return true;
    }

}
