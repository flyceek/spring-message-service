package org.paranora.sms.service.rongyun;

import io.rong.RongCloud;
import org.paranora.sms.entity.RongYunKafkaMessage;
import org.paranora.sms.service.MessageService;
import org.springframework.kafka.core.KafkaTemplate;

public abstract class RongYunKafkaMessageServiceFactoryAbs<TV extends RongYunKafkaMessage> implements RongYunKafkaMessageServiceFactory<String,TV> {
    @Override
    public MessageService createMessageService(KafkaTemplate<String, TV> kafkaTemplate, RongCloud rongCloud) {
        RongYunKafkaMessageService<TV> service = createMessageService();
        service.defaultKafkaTemplate(kafkaTemplate);
        service.defaultRongCloud(rongCloud);
        return service;
    }

    protected abstract RongYunKafkaMessageService<TV> createMessageService();
}
