package org.paranora.sms.service.rongyun;

import org.paranora.sms.entity.RongYunPrivateKafkaMessage;

public class RongYunKafkaPrivateMessageServiceFactory extends RongYunKafkaMessageServiceFactoryAbs<RongYunPrivateKafkaMessage> {
    @Override
    protected RongYunKafkaMessageService<RongYunPrivateKafkaMessage> createMessageService() {
        return new RongYunKafkaPrivateMessageService();
    }
}
