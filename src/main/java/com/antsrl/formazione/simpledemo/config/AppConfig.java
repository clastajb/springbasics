package com.antsrl.formazione.simpledemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        CarConfig.class,
        TruckConfig.class,
        EngineConfig.class})
public class AppConfig {
}
