package org.paranora.sms.rest;


import org.paranora.sms.entity.RongYunPrivateKafkaMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rongyun/message/private")
public class RongYunPrivateMessageRest extends RongYunMessageRest<RongYunPrivateKafkaMessage>{

}
