package org.paranora.sms.service.rongyun;

import io.rong.models.message.GroupMessage;
import io.rong.models.response.ResponseResult;
import org.paranora.sms.entity.RongYunGroupKafkaMessage;
import org.paranora.sms.entity.RongYunMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;

public class RongYunKafkaGroupMessageFetcher extends RongYunKafkaMessageFetcher<RongYunGroupKafkaMessage> {
    private static final Logger log = LoggerFactory.getLogger(RongYunKafkaGroupMessageFetcher.class);


    @Override
    public boolean fetch(RongYunGroupKafkaMessage message) throws Exception {
        message.setContent(URLDecoder.decode(message.getContent(), "UTF-8"));
        String messageJson = message.toString();
        log.info(String.format("\r\nfetch rongyun group message : \r\n%s", messageJson));

        RongYunMessage rongyunMessageContent = new RongYunMessage(message.getObjectName(), message.getContent());
        GroupMessage groupMessage = new GroupMessage()
                .setSenderId(message.getSenderId())
                .setTargetId(new String[]{message.getGroupId()})
                .setToUserId(message.getReceiverIds())
                .setObjectName(message.getObjectName())
                .setContent(rongyunMessageContent)
                .setPushContent(message.getPushContent())
                .setPushData(message.getPushData())
                .setIsPersisted(message.getIsPersisted())
                .setIsIncludeSender(message.getIsIncludeSender())
                .setContentAvailable(message.getContentAvailable());
        ResponseResult result = null;
        if (null != message.getReceiverIds() && message.getReceiverIds().length > 0) {
            result = rongCloud.message.group.sendDirection(groupMessage);
        } else {
            result = rongCloud.message.group.send(groupMessage);
        }

        log.info(String.format("\r\nsend rongyun group message: \r\n %s \r\nresult : \r\n%s", messageJson, result.toString()));
        if (result.code == 200) {
            return true;
        } else {
            return false;
        }
    }
}
