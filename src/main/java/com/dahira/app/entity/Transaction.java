package com.dahira.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user; // membre qui a payé

    @ManyToOne
    private ContributionMembre contributionMembre; // contribution individuelle

    private String type; // INCOME / EXPENSE
    private double amount;
    private String description;
    private LocalDate date;

    private String paymentMethod; // PayTech, OrangeMoney, Wave, PayDunya...
    private String status; // PENDING, SUCCESS, FAILED
    private String externalRef; // référence retournée par l’API de paiement            // PAID / UNPAID / PARTIAL
}
