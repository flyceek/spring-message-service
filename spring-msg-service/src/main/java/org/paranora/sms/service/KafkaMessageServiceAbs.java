package org.paranora.sms.service;

import org.paranora.sms.entity.KafkaMessage;
import org.springframework.kafka.core.KafkaTemplate;

public abstract class KafkaMessageServiceAbs<T extends KafkaMessage> extends MessageServiceAbs<T>{
    public void defaultKafkaTemplate(KafkaTemplate<Integer,String> kafkaTemplate){
    }
}
