package helloworld.HelloWorldapp.application.controllers;

import helloworld.HelloWorldapp.application.dtos.MessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class WSController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/publicChatRoom")
    public MessageDTO sendMessage(@Payload MessageDTO message) {
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/publicChatRoom")
    public MessageDTO addUser(@Payload MessageDTO message, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        Objects.requireNonNull(headerAccessor.getSessionAttributes()).put("username", message.getSender());
        return message;
    }
}
