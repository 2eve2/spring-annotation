package com.flab.dj.springannotation;

import org.springframework.stereotype.Component;

@Component
public class SomeObject {
    @Command("say")
    public String doSay(String word) {
        return "say " + word;
    }

    @Command("tell")
    public String doTell(String word) {
        return "tell " + word;
    }

    @Command("think")
    public String thinkAbout(String word) {
        return "think about " + word;
    }
}
