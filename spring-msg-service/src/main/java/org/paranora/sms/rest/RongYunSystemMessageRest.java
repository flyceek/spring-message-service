package org.paranora.sms.rest;


import org.paranora.sms.entity.RongYunSystemKafkaMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rongyun/message/system")
public class RongYunSystemMessageRest extends RongYunMessageRest<RongYunSystemKafkaMessage>{

}
