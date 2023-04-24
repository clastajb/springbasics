package com.antsrl.formazione.simpledemo;

import com.antsrl.formazione.simpledemo.service.GeolocationService;
import com.antsrl.formazione.simpledemo.service.TransportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.antsrl.formazione.simpledemo");

        TransportService transportService = context.getBean(TransportService.class);
        transportService.movingStuffAroundTheWorld();

        GeolocationService geolocationService = context.getBean(GeolocationService.class);
        geolocationService.trackingStuffAroundTheWorld();
    }
}
