package com.antsrl.formazione.simpledemo.config;

import org.springframework.context.annotation.Import;

@Import({
        CarConfig.class,
        TruckConfig.class,
        EngineConfig.class})
public class AppConfig {
}
