package org.paranora.sms.service.rongyun;

import org.paranora.sms.entity.RongYunPrivateKafkaMessage;
import org.springframework.kafka.core.KafkaTemplate;

public class RongYunKafkaPrivateMessageService extends RongYunKafkaMessageService<RongYunPrivateKafkaMessage> {


    @Override
    public void defaultSender() {
        this.sender=new RongYunKafkaPrivateMessageSender();
    }

    @Override
    public void defaultFetcher() {
        this.fetcher=new RongYunKafkaPrivateMessageFetcher();
    }

    @Override
    public void defaultKafkaTemplate(KafkaTemplate<String, RongYunPrivateKafkaMessage> kafkaTemplate) {
        ((RongYunKafkaPrivateMessageSender)this.sender).defaultKafkaTemplate(kafkaTemplate);
    }
}
