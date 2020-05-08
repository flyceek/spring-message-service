package org.paranora.sms.kafka;

import org.paranora.sms.entity.RongYunKafkaMessage;
import org.paranora.sms.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public abstract class KafkaRonYunMessageConsumerAbs<T extends RongYunKafkaMessage> implements KafkaRonYunMessageConsumer<T> {

    private static final Logger log = LoggerFactory.getLogger(KafkaRonYunMessageConsumerAbs.class);

    @Autowired
    private MessageService<T> messageService;

    @Override
    @KafkaListener(id="${AA_KAFKA_CLIENT_ID}",topics = "${AA_KAFKA_TOPIC}", groupId = "${AA_KAFKA_GROUP_ID}",errorHandler = "kafkaConsumerAwareListenerErrorHandler",containerFactory = "kafkaListenerContainerFactory")
    public void listen(@Payload T msg,
                       @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                       @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts,
                       Acknowledgment ack) throws Exception {
        try {
            messageService.fetch(msg);
        } catch (Exception e){
            log.error(e.getMessage());
            throw  e;
        } finally {
            ack.acknowledge();
        }
    }
}
