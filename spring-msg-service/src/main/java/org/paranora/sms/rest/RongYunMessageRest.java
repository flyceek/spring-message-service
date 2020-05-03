package org.paranora.sms.rest;


import org.paranora.sms.entity.RongYunKafkaMessage;
import org.paranora.sms.entity.dto.RestfulResponse;
import org.paranora.sms.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class RongYunMessageRest<T extends RongYunKafkaMessage> {

    private static final Logger log = LoggerFactory.getLogger(RongYunMessageRest.class);

    @Autowired
    protected MessageService<T> messageService;

    @PostMapping("send")
    public RestfulResponse send(@RequestBody T message) {
        RestfulResponse result=null;
        try {
            messageService.send(message);
            result=RestfulResponse.success();
        } catch (Exception e) {
            log.error("send-error-e :"+e.getMessage());
            result=RestfulResponse.fail("send-error!");
        }
        return result;
    }

    @PostMapping("sendSync")
    public RestfulResponse sendSync(@RequestBody T message) {
        RestfulResponse result=null;
        try {
            messageService.sendSync(message);
            result=RestfulResponse.success();
        } catch (Exception e) {
            log.error("send-error-e :"+e.getMessage());
            result=RestfulResponse.fail("send-error!");
        }
        return result;
    }
}
