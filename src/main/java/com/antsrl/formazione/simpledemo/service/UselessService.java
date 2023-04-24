package com.antsrl.formazione.simpledemo.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class UselessService {

    public UselessService() {
        System.out.println("preparing to be useless");
    }

    public void doingUselessStuffAroundTheWorld(){
        System.out.println("I'm just dicking around");
    }
}
