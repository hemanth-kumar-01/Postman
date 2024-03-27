package org.example.Messages;

import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageService{
    @Override
    public void sendmessage(String msg) {
        System.out.println("Sms Message is "+msg);
    }
}
