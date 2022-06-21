package com.flab.dj;

import com.flab.dj.springannotation.RunAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class MyApp {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);

        RunAnnotation run = applicationContext.getBean("runAnnotation",RunAnnotation.class);

        run.printMethods();
        run.doAction("say", "hello");
        run.doAction("think","world");

    }
}
