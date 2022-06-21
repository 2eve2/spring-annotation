package com.flab.dj.springannotation;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class RunCommand implements RunAnnotation {

    final Map<String, Method> methodMap = new LinkedHashMap<>();
    final Object object;

    public RunCommand(Object object) {
        this.object = object;
    }

    @PostConstruct
    public void postConstruct(){
        Method[] methods = object.getClass().getMethods();
        for (Method m : methods){
            if(m.isAnnotationPresent((Command.class))){
                Command c = m.getAnnotation(Command.class);
                methodMap.put(c.value(),m);
            }
        }
    }

    @Override
    public void printMethods(){
        for(String value : methodMap.keySet()){
            System.out.println(value + " => " + methodMap.get(value));
        }
    }

    @Override
    public void doAction(String CommandValue, String word) throws InvocationTargetException, IllegalAccessException {
        if(methodMap.containsKey(CommandValue)){
            methodMap.get(CommandValue).invoke(object,word);
        }
    }


}
