package com.antsrl.formazione.simpledemo;

import com.antsrl.formazione.simpledemo.config.AppConfig;
import com.antsrl.formazione.simpledemo.service.GeolocationService;
import com.antsrl.formazione.simpledemo.service.TransportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.antsrl.formazione.simpledemo.service");
        context.register(AppConfig.class);
        context.refresh();

        TransportService transportService = context.getBean(TransportService.class);
        transportService.movingStuffAroundTheWorld();

        GeolocationService geolocationService = context.getBean(GeolocationService.class);
        geolocationService.trackingStuffAroundTheWorld();
    }
}
