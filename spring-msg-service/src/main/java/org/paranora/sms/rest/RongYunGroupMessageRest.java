package org.paranora.sms.rest;


import org.paranora.sms.entity.RongYunGroupKafkaMessage;
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
@RequestMapping("/rongyun/message/group")
public class RongYunGroupMessageRest {

    private static final Logger log = LoggerFactory.getLogger(RongYunGroupMessageRest.class);

    @Autowired
    private MessageService rongYunKafkaGroupMessageService;

    @PostMapping("send")
    public RestfulResponse send(@RequestBody RongYunGroupKafkaMessage message) {
        RestfulResponse result=null;
        try {
            rongYunKafkaGroupMessageService.send(message);
            result=RestfulResponse.success();
        } catch (Exception e) {
            log.error("send-error-e :"+e.getMessage());
            result=RestfulResponse.fail("send-error!");
        }
        return result;
    }

    @PostMapping("sendSync")
    public RestfulResponse sendSync(@RequestBody RongYunGroupKafkaMessage message) {
        RestfulResponse result=null;
        try {
            rongYunKafkaGroupMessageService.sendSync(message);
            result=RestfulResponse.success();
        } catch (Exception e) {
            log.error("send-error-e :"+e.getMessage());
            result=RestfulResponse.fail("send-error!");
        }
        return result;
    }
}
