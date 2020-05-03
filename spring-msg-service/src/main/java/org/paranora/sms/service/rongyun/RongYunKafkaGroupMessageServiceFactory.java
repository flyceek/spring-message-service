package org.paranora.sms.service.rongyun;

import org.paranora.sms.entity.RongYunGroupKafkaMessage;

public class RongYunKafkaGroupMessageServiceFactory extends RongYunKafkaMessageServiceFactoryAbs<RongYunGroupKafkaMessage> {
    @Override
    protected RongYunKafkaMessageService<RongYunGroupKafkaMessage> createMessageService() {
        return new RongYunKafkaGroupMessageService();
    }
}
