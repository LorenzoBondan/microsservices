package com.projects.notification.kafka.consumer;

import com.projects.notification.entities.Notification;
import com.projects.notification.kafka.domain.PaymentNotificationEvent;
import com.projects.notification.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentNotificationConsumer {

    private final NotificationRepository notificationRepository;

    @KafkaListener(topics = "${topic.payment-notification}", groupId = "notification-group")
    public void consume(PaymentNotificationEvent event) {
        String message = "Pagamento processado para " + event.getWorkerName() + " no valor de R$ " + event.getAmount();
        notificationRepository.save(Notification.builder()
                        .userId(event.getWorkerId())
                        .message(message)
                        .date(LocalDateTime.now())
                .build());
        System.out.println("🔔 Notificação recebida:");
        System.out.println(message);
    }
}

