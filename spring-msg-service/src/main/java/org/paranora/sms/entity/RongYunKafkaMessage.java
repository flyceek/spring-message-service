package org.paranora.sms.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;


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
    protected Boolean expansion;
    protected Boolean disablePush;
    protected String pushExt;

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

    public Boolean getExpansion() {
        return expansion;
    }

    public void setExpansion(Boolean expansion) {
        this.expansion = expansion;
    }

    public Boolean getDisablePush() {
        return disablePush;
    }

    public void setDisablePush(Boolean disablePush) {
        this.disablePush = disablePush;
    }

    public String getPushExt() {
        return pushExt;
    }

    public void setPushExt(String pushExt) {
        this.pushExt = pushExt;
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

    public String getPushData() {
        return pushData;
    }

    public void setPushData(String pushData) {
        this.pushData = pushData;
    }

    public String getPushContent() {
        return pushContent;
    }

    public void setPushContent(String pushContent) {
        this.pushContent = pushContent;
    }

    public Integer getIsCounted() {
        return isCounted;
    }

    public void setIsCounted(Integer isCounted) {
        this.isCounted = isCounted;
    }

    public Integer getIsIncludeSender() {
        return isIncludeSender;
    }

    public void setIsIncludeSender(Integer isIncludeSender) {
        this.isIncludeSender = isIncludeSender;
    }

    public Integer getIsPersisted() {
        return IsPersisted;
    }

    public void setIsPersisted(Integer isPersisted) {
        IsPersisted = isPersisted;
    }

    public Integer getContentAvailable() {
        return contentAvailable;
    }

    public void setContentAvailable(Integer contentAvailable) {
        this.contentAvailable = contentAvailable;
    }

    public Integer getVerifyBlacklist() {
        return verifyBlacklist;
    }

    public void setVerifyBlacklist(Integer verifyBlacklist) {
        this.verifyBlacklist = verifyBlacklist;
    }
}
