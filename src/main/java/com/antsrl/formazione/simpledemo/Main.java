package com.antsrl.formazione.simpledemo;

import com.antsrl.formazione.simpledemo.bean.Car;
import com.antsrl.formazione.simpledemo.bean.engine.EndothermicEngine;

public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        car.setEngine(new EndothermicEngine());

        car.engineStart();
        car.go();

    }
}
