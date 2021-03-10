package helloworld.HelloWorldapp.application.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        CHAT, JOIN, LEAVE
    }
}
