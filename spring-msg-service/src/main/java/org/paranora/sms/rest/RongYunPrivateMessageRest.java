package org.paranora.sms.rest;


import org.paranora.sms.entity.RongYunKafkaMessage;
import org.paranora.sms.entity.RongYunPrivateKafkaMessage;
import org.paranora.sms.entity.dto.RestfulResponse;
import org.paranora.sms.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rongyun/message/private")
public class RongYunPrivateMessageRest {

    private static final Logger log = LoggerFactory.getLogger(RongYunPrivateMessageRest.class);

    @Autowired
    private MessageService rongYunKafkaPrivateMessageService;

    @PostMapping("send")
    public RestfulResponse send(@RequestBody RongYunPrivateKafkaMessage message) {
        RestfulResponse result=null;
        try {
            rongYunKafkaPrivateMessageService.send(message);
            result=RestfulResponse.success();
        } catch (Exception e) {
            log.error("send-error-e :"+e.getMessage());
            result=RestfulResponse.fail("send-error!");
        }
        return result;
    }

    @PostMapping("sendSync")
    public RestfulResponse sendSync(@RequestBody RongYunPrivateKafkaMessage message) {
        RestfulResponse result=null;
        try {
            rongYunKafkaPrivateMessageService.sendSync(message);
            result=RestfulResponse.success();
        } catch (Exception e) {
            log.error("send-error-e :"+e.getMessage());
            result=RestfulResponse.fail("send-error!");
        }
        return result;
    }
}
