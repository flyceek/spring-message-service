package org.paranora.sms.service.rongyun;

import org.paranora.sms.entity.RongYunKafkaMessage;
import org.paranora.sms.service.MessageFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RongYunKafkaMessageFetcher implements MessageFetcher<RongYunKafkaMessage> {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void fetch(RongYunKafkaMessage message) {
        log.info(message.getContent());
        log.info("fetch message end by paranora.");
    }
}
