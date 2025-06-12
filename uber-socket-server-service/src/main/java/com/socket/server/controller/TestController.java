package com.socket.server.controller;

import com.socket.server.DTO.TestRequest;
import com.socket.server.DTO.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ping")
    @SendTo("/topic/ping")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public TestResponse pingCheck(TestRequest testRequest){
        System.out.println("Message received from data"+testRequest.getData());
        return new  TestResponse("Received");
    }

    @SendTo("/topic/scheduled")
    @Scheduled(fixedRate = 2000)
    public void sendMessageToClient(){
        simpMessagingTemplate.convertAndSend("/topic/scheduled","Periodic message sent"+System.currentTimeMillis());
    }
}
