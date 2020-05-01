package org.paranora.sms.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;

public class KafkaProducerResultHandler implements ProducerListener {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducerResultHandler.class);

    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
//        log.info("send-success : " + producerRecord.toString());
    }

    @Override
    public void onError(ProducerRecord producerRecord, Exception exception) {
        log.error("send-error : " + producerRecord.toString());
        log.error("send-error-ex : " + exception.getMessage());
    }

}
