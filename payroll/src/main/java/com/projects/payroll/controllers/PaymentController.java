package com.projects.payroll.controllers;

import com.projects.payroll.entitites.Payment;
import com.projects.payroll.kafka.domain.PaymentNotificationEvent;
import com.projects.payroll.kafka.producer.KafkaPaymentProducer;
import com.projects.payroll.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;
    private final KafkaPaymentProducer kafkaPaymentProducer;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment payment = service.getPayment(workerId, days);
        kafkaPaymentProducer.sendNotification(PaymentNotificationEvent.builder()
                        .workerId(workerId)
                        .workerName(payment.getName())
                        .amount(payment.getTotal())
                .build());
        return ResponseEntity.ok(payment);
    }
}
