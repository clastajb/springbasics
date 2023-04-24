package com.antsrl.formazione.simpledemo.config;

import com.antsrl.formazione.simpledemo.bean.engine.ElectricEngine;
import com.antsrl.formazione.simpledemo.bean.engine.EndothermicEngine;
import com.antsrl.formazione.simpledemo.bean.engine.Engine;
import org.springframework.context.annotation.Bean;

public class EngineConfig {

    @Bean
    public Engine endothermicEngine(){
        return new EndothermicEngine();
    }

    @Bean
    public Engine electricEngine(){
        return new ElectricEngine();
    }
}
