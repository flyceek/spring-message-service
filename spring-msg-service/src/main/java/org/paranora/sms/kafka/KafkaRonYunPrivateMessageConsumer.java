package org.paranora.sms.kafka;

import org.paranora.sms.entity.RongYunPrivateKafkaMessage;
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
@Profile({"kafka-rongyun-private-message-consumer"})
public class KafkaRonYunPrivateMessageConsumer {

    @Autowired
    private MessageService rongYunKafkaPrivateMessageService;

    @KafkaListener(id="${AA_KAFKA_CLIENT_ID:paranora}",topics = "${AA_KAFKA_TOPIC:paranora-rongyun-private-message}", groupId = "${AA_KAFKA_GROUP_ID:paranora-rongyun-private-message-consumer-group}",errorHandler = "kafkaConsumerAwareListenerErrorHandler",containerFactory = "kafkaListenerContainerFactory")
    public void listen(@Payload RongYunPrivateKafkaMessage msg,
                       @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                       @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts,
                       Acknowledgment ack) throws  Exception {
        if(rongYunKafkaPrivateMessageService.fetch(msg)) {
            ack.acknowledge();
        }
    }

}
