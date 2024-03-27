package org.example.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Customer {
    private int id;
    private String name;
    public Customer(int id,String name){
        this.id=id;
        this.name=name;
    }

    public Customer(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
