package org.paranora.sms.configuration;

import io.rong.RongCloud;
import org.paranora.sms.entity.RongYunGroupKafkaMessage;
import org.paranora.sms.entity.RongYunPrivateKafkaMessage;
import org.paranora.sms.entity.RongYunSystemKafkaMessage;
import org.paranora.sms.service.MessageService;
import org.paranora.sms.service.rongyun.*;
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
    public class RonYunKafkaPrivateMessageConfiguration extends RongYunKafkaPrivateMessageServiceFactory {

        @Bean
        public MessageService rongYunKafkaPrivateMessageService(KafkaTemplate<String, RongYunPrivateKafkaMessage> kafkaTemplate) {
            return createMessageService(kafkaTemplate,rongCloud());
        }
    }

    @Configuration
    @Profile({"kafka-rongyun-group-message-service"})
    public class RonYunKafkaGroupMessageConfiguration extends RongYunKafkaGroupMessageServiceFactory {

        @Bean
        public MessageService rongYunKafkaGroupMessageService(KafkaTemplate<String, RongYunGroupKafkaMessage> kafkaTemplate) {
            return createMessageService(kafkaTemplate,rongCloud());
        }
    }

    @Configuration
    @Profile({"kafka-rongyun-system-message-service"})
    public class RonYunKafkaSystemMessageConfiguration extends RongYunKafkaSystemMessageServiceFactory{

        @Bean
        public MessageService rongYunKafkaSystemMessageService(KafkaTemplate<String, RongYunSystemKafkaMessage> kafkaTemplate) {
            return createMessageService(kafkaTemplate,rongCloud());
        }
    }
}
