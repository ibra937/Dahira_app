package com.dahira.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContributionDahira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;           // Ex: "Monthly Fee - Oct 2025"
    private double totalAmount;    // Montant total fixé par le dahira
    private LocalDate dueDate;     // Date limite de paiement
    private String description;

    @ManyToOne
    private Dahira dahira;

    @OneToMany(mappedBy = "contributionDahira", cascade = CascadeType.ALL)
    private List<ContributionMembre> contributionsMembres;
}
