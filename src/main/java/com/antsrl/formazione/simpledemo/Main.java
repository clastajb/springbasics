package com.antsrl.formazione.simpledemo;

import com.antsrl.formazione.simpledemo.bean.Car;
import com.antsrl.formazione.simpledemo.service.GeolocationService;
import com.antsrl.formazione.simpledemo.service.TransportService;
import com.antsrl.formazione.simpledemo.utils.Utils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.antsrl.formazione.simpledemo");

        TransportService transportService = context.getBean(TransportService.class);
        transportService.movingStuffAroundTheWorld();

        TransportService transportServiceAgain = context.getBean(TransportService.class);

        GeolocationService geolocationService = context.getBean(GeolocationService.class);
        geolocationService.trackingStuffAroundTheWorld();

        Car redCar = context.getBean(Car.class);
        Car blueCar = context.getBean(Car.class);

        Utils.trueOrThrow("transportService should be always the same object!", () -> Objects.equals(transportService, transportServiceAgain));
        Utils.trueOrThrow("cars should NOT be the same object!", () -> !Objects.equals(redCar, blueCar));
    }
}
