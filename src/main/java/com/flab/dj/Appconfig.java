package com.flab.dj;

import com.flab.dj.springannotation.RunAnnotation;
import com.flab.dj.springannotation.RunCommand;
import com.flab.dj.springannotation.CommandObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Appconfig {
    @Bean
    public Object chooseObject(){
        return new CommandObject();
    }

    @Bean
    public RunAnnotation runAnnotation(){
        return new RunCommand(chooseObject());
    }
}
