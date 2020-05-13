package org.paranora.sms.service.rongyun;

import io.rong.models.message.SystemMessage;
import io.rong.models.response.ResponseResult;
import org.paranora.sms.entity.RongYunMessage;
import org.paranora.sms.entity.RongYunSystemKafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;

public class RongYunKafkaSystemMessageFetcher extends RongYunKafkaMessageFetcher<RongYunSystemKafkaMessage> {
    private static final Logger log = LoggerFactory.getLogger(RongYunKafkaSystemMessageFetcher.class);

    @Override
    public boolean fetch(RongYunSystemKafkaMessage message) throws Exception{
        message.setContent(URLDecoder.decode(message.getContent(),"UTF-8"));
        String messageJson=message.toString();
        log.info(String.format("\r\nfetch rongyun system message : \r\n%s",messageJson));

        RongYunMessage rongyunMessageContent = new RongYunMessage(message.getObjectName(),message.getContent());
        SystemMessage systemMessage = new SystemMessage()
                .setSenderId(message.getSenderId())
                .setTargetId(message.getReceiverIds())
                .setObjectName(message.getObjectName())
                .setContent(rongyunMessageContent)
                .setPushContent(message.getIosPushContent())
                .setPushData(message.getIosPushData())
                .setIsPersisted(0)
                .setIsCounted(message.getIosCount())
                .setContentAvailable(message.getIosContentAvailable());

        ResponseResult result = rongCloud.message.system.send(systemMessage);
        log.info(String.format("\r\nsend rongyun system message: \r\n %s \r\nresult : \r\n%s",messageJson,result.toString()));
        if(result.code==200) {
            return true;
        } else {
            return false;
        }
    }
}
