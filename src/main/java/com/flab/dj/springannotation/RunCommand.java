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
    public void init(){
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method m : methods){
            if(m.isAnnotationPresent((Command.class))){
                Command c = m.getAnnotation(Command.class);
                methodMap.put(c.value(),m);
            }
        }
    }
    public void printCommands(){
        for(String k : methodMap.keySet()){
            System.out.println( k + " => " + methodMap.get(k).getName());
        }
    }


    public String doCommand(String commandValue, String word) throws InvocationTargetException, IllegalAccessException {

        Method method = methodMap.get(commandValue);

        if(methodMap.containsKey(commandValue)){
            return (String) method.invoke(object,word);
        }else{
            throw new IllegalAccessException("존재하지 않는 명령문입니다.");
        }
    }
}
