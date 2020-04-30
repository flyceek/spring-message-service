package org.paranora.sms.service.rongyun;

import org.paranora.sms.entity.RongYunKafkaMessage;
import org.paranora.sms.service.KafkaMessageConverterAbs;

public class RongYunKafkaMessageConverter extends KafkaMessageConverterAbs<RongYunKafkaMessage> {


    @Override
    protected Class<RongYunKafkaMessage> getMessageType() {
        return RongYunKafkaMessage.class;
    }
}
