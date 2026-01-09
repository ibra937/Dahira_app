package com.dahira.app.repository;

import com.dahira.app.entity.Dahira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DahiraRepository extends JpaRepository<Dahira, Long> {
}
