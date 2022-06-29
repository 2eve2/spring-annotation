package com.flab.dj.springannotation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class RunCommand{

    final Map<String, Method> methodMap = new LinkedHashMap<>();
    final SomeObject object;

    @PostConstruct
    public void postConstruct(){
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method m : methods){
            if(m.isAnnotationPresent((Command.class))){
                Command c = m.getAnnotation(Command.class);
                methodMap.put(c.value(),m);
            }
        }
    }
    public void printCommands(){
        for(String value : methodMap.keySet()){
            System.out.println(value + " => " + methodMap.get(value).getName());
        }
    }


    public void doCommand(String commandValue, String word) throws InvocationTargetException, IllegalAccessException {
        if(methodMap.containsKey(commandValue)){
            methodMap.get(commandValue).invoke(object,word);
        }
    }
}
