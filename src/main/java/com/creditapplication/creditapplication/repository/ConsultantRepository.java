package com.creditapplication.creditapplication.repository;

import com.creditapplication.creditapplication.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
    boolean existsByEmail(String email);
}
