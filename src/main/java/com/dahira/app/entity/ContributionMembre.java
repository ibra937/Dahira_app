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
public class ContributionMembre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User member;

    @ManyToOne
    private ContributionDahira contributionDahira;

    private double expectedAmount;   // Montant attendu pour ce membre
    private double amountPaid;       // Montant payé
    private LocalDate dueDate;
    private String status;           // PAID / UNPAID / PARTIAL

    @OneToMany(mappedBy = "contributionMembre", cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}
