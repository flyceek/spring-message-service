package org.paranora.sms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RongYunGroupKafkaMessage extends RongYunKafkaMessage {

    private String groupId;

    public RongYunGroupKafkaMessage() {
        this.topic="paranora-rongyun-group-message";
        this.key="rongyun-group-msg";
        this.partition=0;
        this.channelType="GROUP";
    }
}
