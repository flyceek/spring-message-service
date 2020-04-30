package org.paranora.sms.service;

import org.paranora.sms.entity.KafkaMessage;
import org.springframework.kafka.core.KafkaTemplate;

public abstract class KafkaMessageSenderAbs<T extends KafkaMessage> implements MessageSender<T> {
    protected KafkaTemplate<Integer, String> kafkaTemplate;
    protected MessageConverter converter;

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

    public void defaultConverter(MessageConverter converter) {
        this.converter = converter;
    }

    public void defaultKafkaTemplate(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(T message) {
        kafkaTemplate.send(message.getTopic(), converter.toString(message));
    }

    @Override
    public void sendSync(T message) throws Exception {
        kafkaTemplate.send(message.getTopic(), converter.toString(message)).get();
    }
}
