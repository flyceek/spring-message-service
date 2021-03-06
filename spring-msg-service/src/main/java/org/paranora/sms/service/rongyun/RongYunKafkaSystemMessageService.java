package org.paranora.sms.service.rongyun;

import org.paranora.sms.entity.RongYunSystemKafkaMessage;
import org.springframework.kafka.core.KafkaTemplate;

public class RongYunKafkaSystemMessageService extends RongYunKafkaMessageService<RongYunSystemKafkaMessage> {


    @Override
    public void defaultSender() {
        this.sender=new RongYunKafkaSystemMessageSender();
    }

    @Override
    public void defaultFetcher() {
        this.fetcher=new RongYunKafkaSystemMessageFetcher();
    }

    @Override
    public void defaultKafkaTemplate(KafkaTemplate<String, RongYunSystemKafkaMessage> kafkaTemplate) {
        ((RongYunKafkaSystemMessageSender)this.sender).defaultKafkaTemplate(kafkaTemplate);
    }
}
