package org.paranora.smp.rest;

import org.paranora.smp.entity.RestfulResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rongyun")
@ConditionalOnBean({KafkaTemplate.class})
@Profile("sender")
public class RongYunKafkaRest {

    private static final Logger log = LoggerFactory.getLogger(RongYunKafkaRest.class);

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Value("${AA_RONGYUN_MESSAGE_TOPIC:rongyun-message}")
    private String rongYunMessageTopic;

    @PostMapping("send")
    public RestfulResponse send(@RequestBody String message) {
        RestfulResponse result=null;
        try {
            kafkaTemplate.send(rongYunMessageTopic, message);
            log.info("send-success : "+ message);
            result=RestfulResponse.success();
        } catch (Exception e) {
            log.error("send-error :"+message);
            result=RestfulResponse.fail("send-error!");
        }
        return result;
    }

    @PostMapping("sendSync")
    public RestfulResponse sendSync(@RequestBody String message) {
        RestfulResponse result=null;
        try {
            kafkaTemplate.send(rongYunMessageTopic, message).get();
            log.info("send-success : "+ message);
            result=RestfulResponse.success();
        } catch (Exception e) {
            log.error("send-error :"+e.getMessage());
            result=RestfulResponse.fail("send-error!");
        }
        return result;
    }

    @GetMapping("hello")
    public RestfulResponse hello(){
        return RestfulResponse.success("hello,i am paranora.");
    }
}
