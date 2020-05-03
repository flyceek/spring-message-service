package org.paranora.sms.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public abstract class RongYunKafkaMessage extends KafkaMessage implements Serializable {
    protected String objectName;
    protected String channelType;
    protected String source;
    protected String iosPushData;
    protected String iosPushContent;
    protected Integer iosCount;
    protected Integer isIncludeSender;
    protected Integer IsPersisted;
    protected Integer iosContentAvailable;
    protected Integer verifyBlacklist;

    public RongYunKafkaMessage(){
        isIncludeSender=1;
        IsPersisted=1;
        verifyBlacklist=0;
    }

    public Integer getVerifyBlacklist() {
        return verifyBlacklist;
    }

    public void setVerifyBlacklist(Integer verifyBlacklist) {
        this.verifyBlacklist = verifyBlacklist;
    }

    public Integer getIosContentAvailable() {
        return iosContentAvailable;
    }

    public void setIosContentAvailable(Integer iosContentAvailable) {
        this.iosContentAvailable = iosContentAvailable;
    }

    public Integer getIsPersisted() {
        return IsPersisted;
    }

    public void setIsPersisted(Integer isPersisted) {
        IsPersisted = isPersisted;
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
