package com.antsrl.formazione.simpledemo.service;

import com.antsrl.formazione.simpledemo.bean.Car;
import com.antsrl.formazione.simpledemo.bean.Truck;
import org.springframework.stereotype.Component;

@Component
public class TransportService {

    private final Car car;
    private final Truck truck;

    public TransportService(Car car, Truck truck) {
        System.out.println("preparing for transportation");

        this.car = car;
        this.truck = truck;
    }

    public void movingStuffAroundTheWorld(){
        System.out.println("hey, I'm moving stuff around!!");

        car.engineStart();
        car.go();

        truck.engineStart();
        truck.go();

    }
}
