package com.flab.dj.springannotation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RunCommandTest {

    @Autowired
    private RunCommand runCommand;

    @Test
    void printCommands() {

    }

    @Test
    void doCommand() throws InvocationTargetException, IllegalAccessException {
        String s1 = runCommand.doCommand("say", "hello");
        String s2 = runCommand.doCommand("think", "world");

        Assertions.assertThat(s1).isEqualTo("say hello");
        Assertions.assertThat(s2).isEqualTo("think about world");
    }
}