package org.paranora.sms.entity;

public class RongYunPrivateKafkaMessage extends RongYunKafkaMessage {

    public RongYunPrivateKafkaMessage() {
        this.topic="paranora-rongyun-private-message";
        this.key="rongyun-private-msg";
        this.partition=0;
        this.channelType="PRIVATE";
    }
}
