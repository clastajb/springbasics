package com.antsrl.formazione.simpledemo.bean;

import com.antsrl.formazione.simpledemo.bean.engine.Engine;

public class Car {

    private Engine engine;

    public void engineStart(){
        System.out.println("here we go!!");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void go() {
        this.engine.makeSomeNoise();
    }
}
