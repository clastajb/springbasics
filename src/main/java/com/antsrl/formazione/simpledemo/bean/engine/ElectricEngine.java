package com.antsrl.formazione.simpledemo.bean.engine;

public class ElectricEngine implements Engine{
    @Override
    public void makeSomeNoise() {

        System.out.println("beep! beep! beep!");
    }
}
