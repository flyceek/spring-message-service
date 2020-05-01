package org.paranora.sms.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public abstract class RongYunKafkaMessage extends KafkaMessage implements Serializable {
    private String objectName;
    private String channelType;
    private String source;
    private String iosPushData;
    private String iosPushContent;
    private Integer iosCount;
    private Integer isIncludeSender;

    public RongYunKafkaMessage(){
        isIncludeSender=1;
    }

    public String getIosPushData() {
        return iosPushData;
    }

    public void setIosPushData(String iosPushData) {
        this.iosPushData = iosPushData;
    }

    public String getIosPushContent() {
        return iosPushContent;
    }

    public void setIosPushContent(String iosPushContent) {
        this.iosPushContent = iosPushContent;
    }

    public Integer getIosCount() {
        return iosCount;
    }

    public void setIosCount(Integer iosCount) {
        this.iosCount = iosCount;
    }

    public Integer getIsIncludeSender() {
        return isIncludeSender;
    }

    public void setIsIncludeSender(Integer isIncludeSender) {
        this.isIncludeSender = isIncludeSender;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
