package com.antsrl.formazione.simpledemo.service;

import com.antsrl.formazione.simpledemo.bean.Car;
import com.antsrl.formazione.simpledemo.bean.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransportService {

    @Autowired
    private Car car;

    @Autowired
    private Truck truck;

    public TransportService() {
        System.out.println("preparing for transportation");
    }

    public void movingStuffAroundTheWorld(){
        System.out.println("hey, I'm moving stuff around!!");

        car.engineStart();
        car.go();

        truck.engineStart();
        truck.go();

    }
}
