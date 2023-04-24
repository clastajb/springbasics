package com.antsrl.formazione.simpledemo.service;

import org.springframework.stereotype.Component;

@Component
public class GeolocationService {

    public GeolocationService() {
        System.out.println("preparing for geolocation");
    }

    public void trackingStuffAroundTheWorld() {
        System.out.println("geolocating and tracking moving-stuff... basically spying you!");
    }
}
