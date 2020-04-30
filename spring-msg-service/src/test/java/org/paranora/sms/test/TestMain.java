package org.paranora.sms.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.paranora.sms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestMain.class})
@ActiveProfiles({"kafka","kafka-producer","rongyun"})
@ComponentScan({"org.paranora.sms"})
public class TestMain {

    @Autowired
    private MessageService messageService;

    @Test
    public void testA(){
//        for(int i=0;i<2000;i++){
//            RongYunKafkaMessage message=new RongYunKafkaMessage();
//            message.setContent("i am paranora , index :"+i);
//            message.setTopic("rongyun-message");
//            message.setKey("sigle-message");
//
//            messageService.send(message);
//        }


        System.out.println("the end!");
    }

}