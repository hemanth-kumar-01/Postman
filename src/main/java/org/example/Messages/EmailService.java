package org.example.Messages;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService{
    @Override
    public void sendmessage(String msg) {
        System.out.println("Message id "+msg);
    }
}
