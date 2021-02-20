package org.paranora.sms.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

@Data
public abstract class RongYunKafkaMessage extends KafkaMessage implements Serializable {
    protected String objectName;
    protected String channelType;
    protected String source;
    protected String pushData;
    protected String pushContent;
    protected Integer isCounted;
    protected Integer isIncludeSender;
    protected Integer IsPersisted;
    protected Integer contentAvailable;
    protected Integer verifyBlacklist;

    public RongYunKafkaMessage(){
        isIncludeSender=1;
        IsPersisted=1;
        verifyBlacklist=0;
        this.time=System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
