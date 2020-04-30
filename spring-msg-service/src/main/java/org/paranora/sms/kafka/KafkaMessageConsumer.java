package org.paranora.sms.kafka;

import org.paranora.sms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnBean(MessageService.class)
@Profile({"kafka-consumer"})
public class KafkaMessageConsumer {

    @Autowired
    private MessageService service;

    @KafkaListener(id="${AA_KAFKA_CLIENT_ID:paranora}",topics = "${AA_KAFKA_TOPIC:rongyun-message}", groupId = "${AA_KAFKA_GROUP_ID:paranora-group}",containerFactory = "kafkaListenerContainerFactory")
    public void listen(String msgData, Acknowledgment ack) {
        service.fetch(msgData);
        ack.acknowledge();
    }
}
