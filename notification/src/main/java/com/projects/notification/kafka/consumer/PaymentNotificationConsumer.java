package com.projects.notification.kafka.consumer;

import com.projects.notification.kafka.domain.PaymentNotificationEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentNotificationConsumer {

    @KafkaListener(topics = "${topic.payment-notification}", groupId = "notification-group")
    public void consume(PaymentNotificationEvent event) {
        System.out.println("🔔 Notificação recebida:");
        System.out.println("Pagamento processado para " + event.getWorkerName() + " no valor de R$ " + event.getAmount());
    }
}

