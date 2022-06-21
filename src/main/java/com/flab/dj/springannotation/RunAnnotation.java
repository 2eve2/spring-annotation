package com.flab.dj.springannotation;

import java.lang.reflect.InvocationTargetException;

public interface RunAnnotation {
    void printMethods();

    void doAction(String CommandValue, String word) throws InvocationTargetException, IllegalAccessException;
}
