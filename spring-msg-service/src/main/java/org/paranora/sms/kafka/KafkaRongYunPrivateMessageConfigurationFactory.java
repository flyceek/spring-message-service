package org.paranora.sms.kafka;

import org.paranora.sms.entity.RongYunPrivateKafkaMessage;

public class KafkaRongYunPrivateMessageConfigurationFactory extends KafkaConfigurationFactoryAbs<String, RongYunPrivateKafkaMessage> {


    @Override
    public Class<RongYunPrivateKafkaMessage> getValueClass() {
        return RongYunPrivateKafkaMessage.class;
    }
}
