package com.antsrl.formazione.simpledemo;

import com.antsrl.formazione.simpledemo.bean.Car;
import com.antsrl.formazione.simpledemo.bean.Truck;
import com.antsrl.formazione.simpledemo.config.AppConfig;
import com.antsrl.formazione.simpledemo.config.EngineConfig;
import com.antsrl.formazione.simpledemo.service.TransportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.register(EngineConfig.class);
        context.register(TransportService.class);
        context.refresh();

        Car car = context.getBean(Car.class);
        Truck truck = context.getBean(Truck.class);

        car.engineStart();
        car.go();

        truck.engineStart();
        truck.go();

        TransportService transportService = context.getBean(TransportService.class);
        transportService.movingStuffAroundTheWorld();
    }
}
