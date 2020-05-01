package org.paranora.sms.service.rongyun;

import org.paranora.sms.entity.RongYunSystemKafkaMessage;

public class RongYunKafkaSystemMessageFetcher extends RongYunKafkaMessageFetcher<RongYunSystemKafkaMessage> {
    @Override
    public boolean fetch(RongYunSystemKafkaMessage message) {
        return false;
    }
}
