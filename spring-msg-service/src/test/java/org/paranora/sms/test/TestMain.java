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
@ActiveProfiles({"kafka","kafka-rongyun-private-message-producer","kafka-rongyun-private-message-service","rongyun"})
@ComponentScan({"org.paranora.sms"})
public class TestMain {

    @Autowired
    private MessageService messageService;

    @Test
    public void testA(){
//        for(int i=0;i<2000;i++){
//            RongYunPrivateKafkaMessage message=new RongYunPrivateKafkaMessage();
//            message.setContent(String.format("{\"content\":\"i am paranora . index : %s .\",\"extra\":\"source=and_agency\"}",i));
//            message.setTopic("paranora-rongyun-private-message");
//            message.setKey("sigle-message");
//            message.setObjectName("RC:TxtMsg");
//            message.setChannelType("PRIVATE");
//            message.setSenderId("s_021_aa137997");
//            message.setReceiverIds(new String[]{"u_u100079197"});
//
//            messageService.send(message);
//        }


        System.out.println("the end!");
    }

}