package org.paranora.sms.service.rongyun;

import org.paranora.sms.entity.RongYunGroupKafkaMessage;
import org.springframework.kafka.core.KafkaTemplate;

public class RongYunKafkaGroupMessageService extends RongYunKafkaMessageService<RongYunGroupKafkaMessage> {


    @Override
    public void defaultSender() {
        this.sender=new RongYunKafkaGroupMessageSender();
    }

    @Override
    public void defaultFetcher() {
        this.fetcher=new RongYunKafkaGroupMessageFetcher();
    }

    @Override
    public void defaultKafkaTemplate(KafkaTemplate<String, RongYunGroupKafkaMessage> kafkaTemplate) {
        ((RongYunKafkaGroupMessageSender)this.sender).defaultKafkaTemplate(kafkaTemplate);
    }
}
