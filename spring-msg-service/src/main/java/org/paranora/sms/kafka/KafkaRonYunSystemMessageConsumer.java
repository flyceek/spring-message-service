package org.paranora.sms.kafka;

import org.paranora.sms.entity.RongYunSystemKafkaMessage;
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
@Profile({"kafka-rongyun-system-message-consumer"})
public class KafkaRonYunSystemMessageConsumer {

    @Autowired
    private MessageService rongYunKafkaSystemMessageService;

    @KafkaListener(id="${AA_KAFKA_CLIENT_ID:paranora}",topics = "paranora-rongyun-system-message", groupId = "paranora-rongyun-system-message-group",errorHandler = "kafkaConsumerAwareListenerErrorHandler",containerFactory = "kafkaListenerContainerFactory")
    public void listen(@Payload RongYunSystemKafkaMessage msg,
                                   @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                   @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                                   @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                   @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts,
                                   Acknowledgment ack) throws Exception{
        if(rongYunKafkaSystemMessageService.fetch(msg)) {
            ack.acknowledge();
        }
    }
}
