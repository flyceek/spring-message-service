package org.paranora.sms.kafka;

import org.paranora.sms.entity.RongYunGroupKafkaMessage;

public class KafkaRongYunGroupMessageConfigurationFactory extends KafkaConfigurationFactoryAbs<String, RongYunGroupKafkaMessage> {


    @Override
    public Class<RongYunGroupKafkaMessage> getValueClass() {
        return RongYunGroupKafkaMessage.class;
    }
}