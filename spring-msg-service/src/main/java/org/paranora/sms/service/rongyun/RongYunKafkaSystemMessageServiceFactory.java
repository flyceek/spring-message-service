package org.paranora.sms.service.rongyun;

import org.paranora.sms.entity.RongYunSystemKafkaMessage;

public class RongYunKafkaSystemMessageServiceFactory extends RongYunKafkaMessageServiceFactoryAbs<RongYunSystemKafkaMessage> {
    @Override
    protected RongYunKafkaMessageService<RongYunSystemKafkaMessage> createMessageService() {
        return new RongYunKafkaSystemMessageService();
    }
}
