
package com.creditapplication.creditapplication.service;

import com.creditapplication.creditapplication.dto.ConsultantRequestDTO;
import com.creditapplication.creditapplication.entity.Consultant;
import com.creditapplication.creditapplication.repository.ConsultantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultantService {

    private final ConsultantRepository consultantRepository;

    public ConsultantService(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    public Consultant createConsultant(ConsultantRequestDTO request) {

        if (consultantRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Consultant email already exists");
        }

        Consultant consultant = new Consultant(
                request.firstName(),
                request.lastName(),
                request.email()
        );

        return consultantRepository.save(consultant);
    }

    public List<Consultant> findAllConsultants() {
        return consultantRepository.findAll();
    }

    public Consultant findConsultantById(Long id) {
        return consultantRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Consultant not found: " + id));
    }
    
}
