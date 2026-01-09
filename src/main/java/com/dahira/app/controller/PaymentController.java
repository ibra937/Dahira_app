package com.dahira.app.controller;

import com.dahira.app.entity.Transaction;
import com.dahira.app.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    // Démarrer un paiement
    @PostMapping("/initiate/{contributionId}")
    public Transaction initiatePayment(
            @PathVariable Long contributionId,
            @RequestParam double amount,
            @RequestParam String method
    ) {
        return paymentService.initiatePayment(contributionId, amount, method);
    }

    // Confirmer le paiement (callback ou manuel)
    @PostMapping("/confirm/{externalRef}")
    public Transaction confirmPayment(@PathVariable String externalRef) {
        return paymentService.confirmPayment(externalRef);
    }
}
