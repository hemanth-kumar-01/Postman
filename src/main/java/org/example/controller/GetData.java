package org.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class GetData {

    //to iterate the json objects
    public void display(Object[] Obj) {
       Arrays.stream(Obj).forEach((s)->
               System.out.println(s)
       );
    }

    //client side to get data from server using uri by getForEntity
    public void displayCustomerDetails(){
        RestTemplate template = new RestTemplate();
        String url = "http://localhost:8082/api/RestcustomerDetails";
        //now receivng the data in ResponseEntity object
        ResponseEntity<Object[]> received = template.getForEntity(url, Object[].class);
        System.out.println("Received data "+received.getBody());
        for(Object e : received.getBody()){
            System.out.println(e);
        }

        //using streams and lambda
        System.out.println("Using the lambda and stream");
        display(received.getBody());
    }
}
