package org.paranora.sms.kafka;

import org.paranora.sms.entity.RongYunGroupKafkaMessage;
import org.paranora.sms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnBean(MessageService.class)
@Profile({"kafka-rongyun-group-message-consumer"})
public class KafkaRonYunGroupMessageConsumer {

    @Autowired
    private MessageService rongYunKafkaGroupMessageService;

    @KafkaListener(id="${AA_KAFKA_CLIENT_ID:paranora}",topics = "${AA_KAFKA_TOPIC:rongyun-group-message}", groupId = "${AA_KAFKA_GROUP_ID:paranora-group-message-group}",containerFactory = "kafkaListenerContainerFactory")
    public void listenGroupMessage(@Payload RongYunGroupKafkaMessage msg,
                       @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                       @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts,
                       Acknowledgment ack) throws  Exception {
        rongYunKafkaGroupMessageService.fetch(msg);
        ack.acknowledge();
    }
}
