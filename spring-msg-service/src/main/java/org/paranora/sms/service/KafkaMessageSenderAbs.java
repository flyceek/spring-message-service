package org.paranora.sms.service;

import org.paranora.sms.entity.KafkaMessage;
import org.paranora.sms.kafka.KafkaSendResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;

import java.util.HashMap;
import java.util.Map;

public abstract class KafkaMessageSenderAbs<T extends KafkaMessage> implements MessageSender<T> {
    private static final Logger log = LoggerFactory.getLogger(KafkaMessageSenderAbs.class);

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
        GenericMessage msg=buildMessage(message);
        kafkaTemplate.send(msg);
        log.info("send-success : " + msg.getPayload());
    }

    @Override
    public void sendSync(T message) throws Exception {
        GenericMessage msg=buildMessage(message);
        kafkaTemplate.send(msg).get();
        log.info("send-success : " + msg.getPayload());
    }

    protected  GenericMessage buildMessage(T message){
        Map msgMap = new HashMap<>();
        msgMap.put(KafkaHeaders.TOPIC, message.getTopic());
        msgMap.put(KafkaHeaders.MESSAGE_KEY, message.getKey());
        msgMap.put(KafkaHeaders.PARTITION_ID, 0);
        msgMap.put(KafkaHeaders.TIMESTAMP, System.currentTimeMillis());
        String msgRaw=converter.toString(message);
        GenericMessage msg=new GenericMessage(msgRaw,msgMap);
        return msg;
    }
}
