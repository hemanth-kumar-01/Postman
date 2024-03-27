package org.example.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageController {
    //now i have 2 components using autowire i am injecting the DI in messagecontroller
    //contructor DI

    private final MessageService messageservice;

    @Autowired
    public MessageController(MessageService msg){
        this.messageservice = msg;
    }

    public void sendMessage(){
        messageservice.sendmessage("Hii");
    }
}
