package org.paranora.sms.service.rongyun;

import io.rong.messages.BaseMessage;
import io.rong.methods.message._private.Private;
import io.rong.models.message.PrivateMessage;
import io.rong.models.response.ResponseResult;
import org.paranora.sms.entity.RongYunPrivateKafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;

public class RongYunKafkaPrivateMessageFetcher extends RongYunKafkaMessageFetcher<RongYunPrivateKafkaMessage> {
    private static final Logger log = LoggerFactory.getLogger(RongYunKafkaPrivateMessageFetcher.class);

    @Override
    public void fetch(RongYunPrivateKafkaMessage message) throws Exception {
        message.setContent(URLDecoder.decode(message.getContent(),"UTF-8"));
        String messageStr=message.toString();
        log.info(String.format("fetch rongyun message : \r\n%s",messageStr));
        Private Private = rongCloud.message.msgPrivate;
        BaseMessage rongyunMessageContent = new BaseMessage() {
            @Override
            public String getType() {
                return message.getChannelType();
            }

            @Override
            public String toString() {
                return message.getContent();
            }
        };
        PrivateMessage rongyunPrivateMessage = new PrivateMessage()
                .setSenderId(message.getSenderId())
                .setTargetId(message.getReceiverIds())
                .setObjectName(message.getObjectName())
                .setContent(rongyunMessageContent)
                .setPushContent(message.getIosPushContent())
                .setPushData(message.getIosPushData())
                .setVerifyBlacklist(0)
                .setIsPersisted(1)
                .setIsCounted(message.getIosCount())
                .setIsIncludeSender(message.getIsIncludeSender());
        ResponseResult privateResult = Private.send(rongyunPrivateMessage);
        log.info(String.format("send rongyun message: \r\n %s \r\nresult : \r\n%s",messageStr,privateResult.toString()));
    }
}
