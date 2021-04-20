package org.paranora.sms.entity;

public class RongYunSystemKafkaMessage extends RongYunPrivateKafkaMessage {

    public RongYunSystemKafkaMessage() {
        this.topic="paranora-rongyun-system-message";
        this.key="rongyun-system-msg";
        this.partition=0;
        this.channelType="SYSTEM";
    }
}
