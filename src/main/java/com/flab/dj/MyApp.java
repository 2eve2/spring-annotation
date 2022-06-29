package com.flab.dj;

import com.flab.dj.springannotation.RunCommand;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class MyApp {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        RunCommand run = ac.getBean("runCommand", RunCommand.class);

        run.printCommands();
        run.doCommand("say", "hello");
        run.doCommand("think","world");

    }
}
