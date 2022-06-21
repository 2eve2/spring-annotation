package com.flab.dj.springannotation;

public class SaySomething {
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
