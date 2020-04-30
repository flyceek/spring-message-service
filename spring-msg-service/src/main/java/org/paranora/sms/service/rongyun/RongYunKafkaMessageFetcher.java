package org.paranora.sms.service.rongyun;

import io.rong.messages.TxtMessage;
import io.rong.models.message.PrivateMessage;
import org.paranora.sms.entity.RongYunKafkaMessage;
import org.paranora.sms.service.MessageFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;

public class RongYunKafkaMessageFetcher implements MessageFetcher<RongYunKafkaMessage> {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void fetch(RongYunKafkaMessage message) {

    }
}
