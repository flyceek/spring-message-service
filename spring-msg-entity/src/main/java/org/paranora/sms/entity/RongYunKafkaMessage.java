package org.paranora.sms.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper=true)
public abstract class RongYunKafkaMessage extends KafkaMessage implements Serializable {

    protected String objectName;
    protected String channelType;
    protected String source;
    protected String pushData;
    protected String pushContent;
    protected Integer isCounted;
    protected Integer count;
    protected Integer isIncludeSender;
    protected Integer isPersisted;
    protected Integer contentAvailable;
    protected Integer verifyBlacklist;
    protected Boolean expansion;
    protected Boolean disablePush;
    protected String pushExt;

    public RongYunKafkaMessage() {
        isIncludeSender = 1;
        isPersisted = 1;
        verifyBlacklist = 0;
        this.time = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
