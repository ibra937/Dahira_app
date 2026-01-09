package com.dahira.app.repository;

import com.dahira.app.entity.ContributionMembre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContributionMembreRepository extends JpaRepository<ContributionMembre,Long> {
    Optional<ContributionMembre> findById(Long id);
}
