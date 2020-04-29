package org.paranora.smf.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@Profile("kafka")
public class KafkaConsumer {
    private Logger log = LoggerFactory.getLogger(this.getClass());


    @KafkaListener(id="paranora",topics = "rongyun-message", containerFactory = "kafkaListenerContainerFactory")
    public void listen(String msgData, Acknowledgment ack) {
        log.info("demo receive : " + msgData);
        ack.acknowledge();
    }

}
