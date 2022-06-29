package com.flab.dj.springannotation;

import org.springframework.stereotype.Component;

@Component
public class SomeObject {
    @Command("say")
    public void doSay(String word) {
        System.out.println("say " + word);
    }

    @Command("tell")
    public void doTell(String word) {
        System.out.println("tell " + word);
    }

    @Command("think")
    public void thinkAbout(String word) {
        System.out.println("think about " + word);
    }
}