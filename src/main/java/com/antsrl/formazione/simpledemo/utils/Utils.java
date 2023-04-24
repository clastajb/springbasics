package com.antsrl.formazione.simpledemo.utils;

import java.util.concurrent.Callable;

public class Utils {

    public static void trueOrThrow(String message, Callable<Boolean> callable) {

        try {

            if (!callable.call()) {
                throw new RuntimeException(message);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
