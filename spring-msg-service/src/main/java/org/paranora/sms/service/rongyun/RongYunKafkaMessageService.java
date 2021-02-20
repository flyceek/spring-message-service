package org.paranora.sms.service.rongyun;

import io.rong.RongCloud;
import org.paranora.sms.entity.RongYunKafkaMessage;
import org.paranora.sms.service.KafkaMessageServiceAbs;

public abstract class RongYunKafkaMessageService<T extends RongYunKafkaMessage> extends KafkaMessageServiceAbs<T> {

    public void defaultRongCloud(RongCloud rongCloud){
        ((RongYunKafkaMessageFetcher)this.fetcher).defaultRongCloud(rongCloud);
    }
}
