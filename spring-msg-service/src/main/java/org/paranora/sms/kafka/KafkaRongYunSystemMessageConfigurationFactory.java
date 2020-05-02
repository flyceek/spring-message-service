package org.paranora.sms.kafka;

import org.paranora.sms.entity.RongYunSystemKafkaMessage;

public class KafkaRongYunSystemMessageConfigurationFactory extends KafkaConfigurationFactoryAbs<String, RongYunSystemKafkaMessage> {


    @Override
    public Class<RongYunSystemKafkaMessage> getValueClass() {
        return RongYunSystemKafkaMessage.class;
    }
}