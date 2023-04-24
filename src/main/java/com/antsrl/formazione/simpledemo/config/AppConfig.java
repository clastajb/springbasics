package com.antsrl.formazione.simpledemo.config;

import com.antsrl.formazione.simpledemo.bean.Car;
import com.antsrl.formazione.simpledemo.bean.engine.EndothermicEngine;
import com.antsrl.formazione.simpledemo.bean.engine.Engine;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public Car car(){
        Car car = new Car();
        car.setEngine(endothermicEngine());
        return car;
    }

    public Engine endothermicEngine(){
        return new EndothermicEngine();
    }
}
