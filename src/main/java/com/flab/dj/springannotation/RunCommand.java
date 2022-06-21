package com.flab.dj.springannotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class RunCommand {

    final Map<String, Method> methodMap = new LinkedHashMap<>();
    final SaySomething ss;
    public RunCommand(SaySomething ss) {
        this.ss = ss;
        Method[] methods = ss.getClass().getMethods();
        for (Method m : methods){
            if(m.isAnnotationPresent((Command.class))){
                Command c = m.getAnnotation(Command.class);
                methodMap.put(c.value(),m);
            }
        }
    }

    public void printCommands(){
        for(String value : methodMap.keySet()){
            System.out.println(value + " => " + methodMap.get(value));
        }
    }

    public void doCommand(String CommandValue, String word) throws InvocationTargetException, IllegalAccessException {
        if(methodMap.containsKey(CommandValue)){
            methodMap.get(CommandValue).invoke(ss,word);
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        SaySomething ss = new SaySomething();
        RunCommand run = new RunCommand(ss);

        run.printCommands();
        run.doCommand("say", "hello");
        run.doCommand("think","world");

    }
}
