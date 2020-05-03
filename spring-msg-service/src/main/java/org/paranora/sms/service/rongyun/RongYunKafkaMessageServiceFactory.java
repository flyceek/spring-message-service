package org.paranora.sms.service.rongyun;

import io.rong.RongCloud;
import org.paranora.sms.entity.Message;
import org.paranora.sms.service.MessageService;
import org.springframework.kafka.core.KafkaTemplate;

public interface RongYunKafkaMessageServiceFactory<TK extends Object, TV extends Message> {
    MessageService createMessageService(KafkaTemplate<TK, TV> kafkaTemplate, RongCloud rongCloud);
}
