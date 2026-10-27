
package com.creditapplication.creditapplication.controller;

import com.creditapplication.creditapplication.dto.ConsultantRequestDTO;
import com.creditapplication.creditapplication.entity.Consultant;
import com.creditapplication.creditapplication.service.ConsultantService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultants")
public class ConsultantController {

    private final ConsultantService consultantService;

    public ConsultantController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    @PostMapping
    public ResponseEntity<Consultant> createConsultant(
            @Valid @RequestBody ConsultantRequestDTO request) {

        Consultant consultant = consultantService.createConsultant(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(consultant);
    }

    @GetMapping
    public List<Consultant> findAllConsultants() {
        return consultantService.findAllConsultants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultant> findConsultantById(@PathVariable Long id) {

        return ResponseEntity.ok(
                consultantService.findConsultantById(id)
        );
    }
}
