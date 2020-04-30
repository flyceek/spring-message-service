package org.paranora.sms.service.rongyun;

import org.paranora.sms.entity.RongYunKafkaMessage;
import org.paranora.sms.service.KafkaMessageServiceAbs;
import org.springframework.kafka.core.KafkaTemplate;

public abstract class RongYunKafkaMessageServiceAbs<T extends RongYunKafkaMessage> extends KafkaMessageServiceAbs<T> {

    @Override
    protected void init() {
        RongYunKafkaMessageConverter converter=new RongYunKafkaMessageConverter();
        RongYunKafkaMessageSender sender=new RongYunKafkaMessageSender();

        sender.defaultConverter(converter);
        defaultConverter(converter);
        defaultFetcher(new RongYunKafkaMessageFetcher());
        defaultSender(sender);
    }

    @Override
    public void defaultKafkaTemplate(KafkaTemplate<Integer, String> kafkaTemplate) {
        ((RongYunKafkaMessageSender)sender).defaultKafkaTemplate(kafkaTemplate);
    }
}
