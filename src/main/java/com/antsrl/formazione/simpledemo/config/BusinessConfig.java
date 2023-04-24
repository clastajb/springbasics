package com.antsrl.formazione.simpledemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class BusinessConfig {

    /** @return a generic {@link  java.lang.Object  Object} 'cause it's just a demonstration */
    @Bean
    public Object optionalBusinessService(@Value("${load-optional-business-service:false}") Boolean loadTheBean){

        if(loadTheBean){
            System.out.println("loading an optional business service!!");
            return new Object();

        } else {

            System.out.println("NOT loading any optional business service!!");
            return null;
        }
    }
}
