package com.antsrl.formazione.simpledemo.config;

import com.antsrl.formazione.simpledemo.bean.Truck;
import com.antsrl.formazione.simpledemo.bean.engine.Engine;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class TruckConfig {

    @Bean
    public Truck endothermicTruck(@Qualifier("endothermicEngine") Engine engine){
        Truck truck = new Truck();
        truck.setEngine(engine);
        return truck;
    }

    @Bean(initMethod = "loadCargo")
    public Truck electricTruck(@Qualifier("electricEngine") Engine engine){
        Truck truck = new Truck();
        truck.setEngine(engine);
        return truck;
    }
}
