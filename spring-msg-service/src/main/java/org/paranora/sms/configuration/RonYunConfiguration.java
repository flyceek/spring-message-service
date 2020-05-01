package org.paranora.sms.configuration;

import io.rong.RongCloud;
import org.paranora.sms.entity.RongYunGroupKafkaMessage;
import org.paranora.sms.entity.RongYunPrivateKafkaMessage;
import org.paranora.sms.entity.RongYunSystemKafkaMessage;
import org.paranora.sms.service.MessageService;
import org.paranora.sms.service.rongyun.RongYunKafkaGroupMessageService;
import org.paranora.sms.service.rongyun.RongYunKafkaPrivateMessageService;
import org.paranora.sms.service.rongyun.RongYunKafkaSystemMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;


@Configuration
@Profile({"rongyun"})
public class RonYunConfiguration {

    @Value("${rongyun.appKey}")
    private String ronYunAppKey;

    @Value("${rongyun.appSecret}")
    private String rongYunAppSecret;

    @Bean
    public RongCloud rongCloud() {
        RongCloud rongCloud = RongCloud.getInstance(ronYunAppKey, rongYunAppSecret);
        return rongCloud;
    }

    @Configuration
    @Profile({"kafka-rongyun-private-message-service"})
    public class RonYunKafkaPrivateMessageConfiguration {

        @Bean
        public MessageService rongYunKafkaPrivateMessageService(KafkaTemplate<String, RongYunPrivateKafkaMessage> kafkaTemplate) {
            RongYunKafkaPrivateMessageService service = new RongYunKafkaPrivateMessageService();
            service.defaultKafkaTemplate(kafkaTemplate);
            service.defaultRongCloud(rongCloud());
            return service;
        }
    }

    @Configuration
    @Profile({"kafka-rongyun-group-message-service"})
    public class RonYunKafkaGroupMessageConfiguration {

        @Bean
        public MessageService rongYunKafkaGroupMessageService(KafkaTemplate<String, RongYunGroupKafkaMessage> kafkaTemplate) {
            RongYunKafkaGroupMessageService service = new RongYunKafkaGroupMessageService();
            service.defaultKafkaTemplate(kafkaTemplate);
            service.defaultRongCloud(rongCloud());
            return service;
        }
    }

    @Configuration
    @Profile({"kafka-rongyun-system-message-service"})
    public class RonYunKafkaSystemMessageConfiguration {

        @Bean
        public MessageService rongYunKafkaGroupMessageService(KafkaTemplate<String, RongYunSystemKafkaMessage> kafkaTemplate) {
            RongYunKafkaSystemMessageService service = new RongYunKafkaSystemMessageService();
            service.defaultKafkaTemplate(kafkaTemplate);
            service.defaultRongCloud(rongCloud());
            return service;
        }
    }
}
