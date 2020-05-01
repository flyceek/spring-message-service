package org.paranora.sms.service.rongyun;

import org.paranora.sms.entity.RongYunGroupKafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RongYunKafkaGroupMessageFetcher extends RongYunKafkaMessageFetcher<RongYunGroupKafkaMessage> {
    private static final Logger log = LoggerFactory.getLogger(RongYunKafkaGroupMessageFetcher.class);


    @Override
    public boolean fetch(RongYunGroupKafkaMessage message) {
        log.info(message.toString());
        return false;
    }
}
