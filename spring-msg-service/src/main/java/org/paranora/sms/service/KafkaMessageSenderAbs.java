package org.paranora.sms.service;

import org.paranora.sms.entity.KafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public abstract class KafkaMessageSenderAbs<T extends KafkaMessage> implements MessageSender<T> {
    private static final Logger log = LoggerFactory.getLogger(KafkaMessageSenderAbs.class);

    protected KafkaTemplate<String, T> kafkaTemplate;

    public KafkaMessageSenderAbs() {
        init();
    }

    protected void init() {
        defaultKafkaTemplate();
        defaultConverter();
    }

    public void defaultKafkaTemplate() {

    }

    public void defaultConverter() {

    }

    public void defaultKafkaTemplate(KafkaTemplate<String, T> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(T message) {
        Message msg=buildMessage(message);
        kafkaTemplate.send(msg);
        log.info("send-success : " + msg.toString());
    }

    @Override
    public void sendSync(T message) throws Exception {
        Message msg=buildMessage(message);
        kafkaTemplate.send(msg).get();
        log.info("send-success : " + msg.toString());
    }

    protected  Message<T> buildMessage(T message){
        Message<T> kafkaMessage = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, message.getTopic())
                .setHeader(KafkaHeaders.MESSAGE_KEY, message.getKey())
                .setHeader(KafkaHeaders.TIMESTAMP, System.currentTimeMillis())
                .build();
        return kafkaMessage;
    }
}
