package com.creditapplication.creditapplication.service;

import com.creditapplication.creditapplication.entity.Client;
import com.creditapplication.creditapplication.exception.ClientNotFoundException;
import com.creditapplication.creditapplication.repository.ClientRepository;
import com.creditapplication.creditapplication.dto.ClientRequestDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(ClientRequestDTO request) {
        Client client = new Client(
                request.firstName(),
                request.lastName(),
                request.employer()
        );
        return clientRepository.save(client);
    }

    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }


    public Client findClientById(Long id) {

        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }



    public Client updateClient(Long id, ClientRequestDTO request) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        client.setFirstName(request.firstName());
        client.setLastName(request.lastName());
        client.setEmployer(request.employer());

        return clientRepository.save(client);
    }



    public void deleteClient(Long id) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        clientRepository.delete(client);
    }


}
