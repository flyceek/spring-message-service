package org.paranora.sms.rest;


import org.paranora.sms.entity.RongYunGroupKafkaMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rongyun/message/group")
public class RongYunGroupMessageRest extends RongYunMessageRest<RongYunGroupKafkaMessage> {


}
