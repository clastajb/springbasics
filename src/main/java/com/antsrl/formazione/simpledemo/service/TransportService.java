package com.antsrl.formazione.simpledemo.service;

import com.antsrl.formazione.simpledemo.bean.Car;
import com.antsrl.formazione.simpledemo.bean.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TransportService {

    @Autowired
    @Qualifier("optionalBusinessService")
    Optional<Object> businessService;

    @Autowired
    private Car car;

    @Autowired
    @Qualifier("endothermicTruck")
    private Truck mailDeliveryTruck;

    @Autowired
    @Qualifier("electricTruck")
    private Truck watermellonShippingTruck;

    public TransportService() {
        System.out.println("preparing for transportation");
    }

    public void movingStuffAroundTheWorld(){
        System.out.println("hey, I'm moving stuff around!!");

        car.engineStart();
        car.go();

        // calling loadCargo() programmatically
        mailDeliveryTruck.engineStart();
        mailDeliveryTruck.loadCargo();
        mailDeliveryTruck.go();

        // no need to explicitly call loadCargo() !!
        watermellonShippingTruck.engineStart();
        watermellonShippingTruck.go();

        businessService.ifPresentOrElse(
                businessService -> System.out.println("businessService is available!"),
                () -> System.out.println("businessService not provided"));
    }
}
