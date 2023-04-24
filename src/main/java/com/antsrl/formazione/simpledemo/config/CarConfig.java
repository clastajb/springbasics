package com.antsrl.formazione.simpledemo.config;

import com.antsrl.formazione.simpledemo.bean.Car;
import com.antsrl.formazione.simpledemo.bean.engine.Engine;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class CarConfig {

    @Bean
    public Car car(@Qualifier("electricEngine") Engine engine){
        Car car = new Car();
        car.setEngine(engine);
        return car;
    }
}
