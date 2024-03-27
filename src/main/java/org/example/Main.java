package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.example.Messages.EmailService;
import org.example.Messages.MessageController;
import org.example.controller.Controller;
import org.example.controller.GetData;
import org.example.entity.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
        GetData d = new GetData();
        d.displayCustomerDetails();
        EmailService em = new EmailService();
        MessageController m = new MessageController(em);//i am sending em service obj
    }
}