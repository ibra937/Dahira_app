package com.dahira.app.service;

import com.dahira.app.entity.ContributionMembre;
import com.dahira.app.entity.Transaction;
import com.dahira.app.repository.ContributionMembreRepository;
import com.dahira.app.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final TransactionRepository transactionRepository;
    private final ContributionMembreRepository contributionMembreRepository;

    // 1️⃣ Étape : Initier un paiement
    public Transaction initiatePayment(Long contributionMembreId, double amount, String method) {
        ContributionMembre contribution = contributionMembreRepository.findById(contributionMembreId)
                .orElseThrow(() -> new RuntimeException("Contribution not found"));

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDate(LocalDate.now());
        transaction.setType("INCOME");
        transaction.setPaymentMethod(method);
        transaction.setStatus("PENDING");
        transaction.setDescription("Payment for contribution " + contributionMembreId);
        transaction.setContributionMembre(contribution);
        transaction.setUser(contribution.getMember());
        transaction.setExternalRef(UUID.randomUUID().toString()); // référence simulée

        return transactionRepository.save(transaction);
    }

    // 2️⃣ Étape : Confirmer le paiement (callback simulé)
    public Transaction confirmPayment(String externalRef) {
        Transaction transaction = transactionRepository.findAll().stream()
                .filter(t -> t.getExternalRef().equals(externalRef))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        transaction.setStatus("SUCCESS");
        transactionRepository.save(transaction);

        ContributionMembre contribution = transaction.getContributionMembre();
        contribution.setStatus("PAID");
        contribution.setAmountPaid(transaction.getAmount());
        contributionMembreRepository.save(contribution);

        return transaction;
    }
}
