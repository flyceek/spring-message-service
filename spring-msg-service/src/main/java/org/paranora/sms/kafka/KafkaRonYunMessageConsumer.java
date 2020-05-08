package org.paranora.sms.kafka;

import org.paranora.sms.entity.RongYunKafkaMessage;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public interface KafkaRonYunMessageConsumer<T extends RongYunKafkaMessage> {

    void listen(@Payload T msg,
                       @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                       @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts,
                       Acknowledgment ack) throws  Exception ;
}
