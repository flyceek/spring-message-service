package org.paranora.sms.kafka;

import org.paranora.sms.entity.RongYunSystemKafkaMessage;
import org.paranora.sms.service.MessageService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnBean(MessageService.class)
@Profile({"kafka-rongyun-system-message-consumer"})
public class KafkaRonYunSystemMessageConsumer extends KafkaRonYunMessageConsumerAbs<RongYunSystemKafkaMessage>{

}
