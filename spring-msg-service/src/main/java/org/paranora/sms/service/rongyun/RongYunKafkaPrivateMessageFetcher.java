package org.paranora.sms.service.rongyun;

import io.rong.models.message.PrivateMessage;
import io.rong.models.response.ResponseResult;
import org.paranora.sms.entity.RongYunMessage;
import org.paranora.sms.entity.RongYunPrivateKafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;

public class RongYunKafkaPrivateMessageFetcher extends RongYunKafkaMessageFetcher<RongYunPrivateKafkaMessage> {
    private static final Logger log = LoggerFactory.getLogger(RongYunKafkaPrivateMessageFetcher.class);

    @Override
    public boolean fetch(RongYunPrivateKafkaMessage message) throws Exception {
        message.setContent(URLDecoder.decode(message.getContent(),"UTF-8"));
        String messageJson=message.toString();
        log.info(String.format("\r\nfetch rongyun private message : \r\n%s",messageJson));

        RongYunMessage rongyunMessageContent = new RongYunMessage(message.getObjectName(),message.getContent());
        PrivateMessage rongyunPrivateMessage = new PrivateMessage()
                .setSenderId(message.getSenderId())
                .setTargetId(message.getReceiverIds())
                .setObjectName(message.getObjectName())
                .setContent(rongyunMessageContent)
                .setPushContent(message.getIosPushContent())
                .setPushData(message.getIosPushData())
                .setVerifyBlacklist(message.getVerifyBlacklist())
                .setIsPersisted(message.getIsPersisted())
                .setIsCounted(message.getIosCount())
                .setIsIncludeSender(message.getIsIncludeSender())
                .setContentAvailable(message.getIosContentAvailable());
        ResponseResult result = rongCloud.message.msgPrivate.send(rongyunPrivateMessage);

        log.info(String.format("\r\nsend rongyun private message: \r\n %s \r\nresult : \r\n%s",messageJson,result.toString()));
        if(result.code==200) {
            return true;
        } else {
            return false;
        }
    }
}
