package org.paranora.sms.kafka;

import org.paranora.sms.entity.RongYunKafkaMessage;
import org.springframework.kafka.support.serializer.JsonSerializer;


public class RongYunKafkaMessageSerializable extends JsonSerializer<RongYunKafkaMessage> {


}
