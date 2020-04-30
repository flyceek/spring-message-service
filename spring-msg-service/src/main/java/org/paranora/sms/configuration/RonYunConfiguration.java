package org.paranora.sms.configuration;

import org.paranora.sms.service.MessageService;
import org.paranora.sms.service.rongyun.RongYunKafkaMessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;


@Configuration
@Profile({"rongyun"})
public class RonYunConfiguration {

    @Bean
    public MessageService rongYunKafkaMessageService(KafkaTemplate<Integer, String> kafkaTemplate){
        RongYunKafkaMessageService service= new RongYunKafkaMessageService();
        service.defaultKafkaTemplate(kafkaTemplate);
        return service;
    }
}
