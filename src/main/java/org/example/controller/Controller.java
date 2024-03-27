package org.example.controller;


import org.example.entity.Customer;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller { //this class is source controller to another restcontroller

    //sample data to display on web
    @GetMapping("/customerDetails1") //sending object data to webpage
    public List<Customer> getCustomerDetails(){
        System.out.println("Constomer details invoked");
        Customer c1 = new Customer(1,"Hemanth");
        Customer c2 = new Customer(2,"Harish");
        List<Customer> arr = new ArrayList<>();
        arr.add(c1);
        arr.add(c2);
        return arr;
    }

    @GetMapping("/send")
    public ResponseEntity<Customer> sendDataToDestination() {
        // Make a POST request to the destination controller running on port 8081
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Customer c2 = new Customer(1,"Vignesh");
        HttpEntity<Customer> requestEntity = new HttpEntity<>(c2, headers);
        RestTemplate restTemplate= new RestTemplate();
        String url = "http://localhost:8082/api/customerDetails2";
        ResponseEntity<Customer> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Customer.class);

        System.out.println(response.getBody());
        return ResponseEntity.ok(response.getBody());
    }

    //Using postTemplate to send the data to location like exchance
    //template obj->HttpHeader(set type of data)->HttpEntity(data,headers)->postForEntity(url,HttpEntityObj,Type.class)
    @GetMapping("/send1")
    public ResponseEntity<Customer>sendDataToDestination1(){
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = "http://localhost:8082/api/receive";
        Customer c = new Customer(2,"ravi");
        HttpEntity<Customer> requestEntity = new HttpEntity<>(c, headers);
        ResponseEntity<Customer>responseEntity = template.postForEntity(
                url,
                requestEntity,
                Customer.class
        );
        System.out.println("send1 imapping is invoked");
        return ResponseEntity.ok(responseEntity.getBody());
    }

    //Another way using the execute method
    @GetMapping("/welcome")
    public String Welcome(){
        System.out.println("welcome is invoked");
        return "Welcome to spring rest1 controller";
    }
    //@ControllerAdvice is globally exceptional handiling annotation
}
