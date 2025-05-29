package com.projects.notification.kafka.domain;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentNotificationEvent {
    private Long workerId;
    private String workerName;
    private Double amount;
}

