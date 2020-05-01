package org.paranora.sms.service.rongyun;

import io.rong.RongCloud;
import org.paranora.sms.entity.RongYunKafkaMessage;
import org.paranora.sms.service.KafkaMessageFetcherAbs;

public abstract class RongYunKafkaMessageFetcher<T extends  RongYunKafkaMessage> extends KafkaMessageFetcherAbs<T> {

    protected RongCloud rongCloud;

    public void defaultRongCloud(RongCloud rongCloud){
        this.rongCloud=rongCloud;
    }
}
