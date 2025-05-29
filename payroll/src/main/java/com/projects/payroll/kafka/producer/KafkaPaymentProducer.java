package com.projects.payroll.kafka.producer;

import com.projects.payroll.kafka.domain.PaymentNotificationEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPaymentProducer {

    private final KafkaTemplate<String, PaymentNotificationEvent> kafkaTemplate;

    @Value("${topic.payment-notification}")
    private String topic;

    public KafkaPaymentProducer(KafkaTemplate<String, PaymentNotificationEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(PaymentNotificationEvent event) {
        kafkaTemplate.send(topic, event);
    }
}
