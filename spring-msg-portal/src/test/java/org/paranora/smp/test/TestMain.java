package org.paranora.smp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("kafka")
public class TestMain {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Value("${AA_RONGYUN_MESSAGE_TOPIC:rongyun-message}")
    private String rongYunMessageTopic;

    @Test
    public void test() throws InterruptedException {
        for(int i=0;i<5000;i++){
            kafkaTemplate.send(rongYunMessageTopic, String.format("paranora is king . index {0}",i));;
            Thread.sleep(100);
        }

        System.console().printf("end");
        System.console().readLine();
    }

}