package com.antsrl.formazione.simpledemo.service;

import org.springframework.stereotype.Component;

@Component
public class TransportService {

    public TransportService() {
        System.out.println("preparing for transportation");
    }

    public void movingStuffAroundTheWorld(){
        System.out.println("hey, I'm moving stuff around!!");
    }
}
