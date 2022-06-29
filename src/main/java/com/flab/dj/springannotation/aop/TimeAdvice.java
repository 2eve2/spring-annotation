package com.flab.dj.springannotation.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;


@Component
@Aspect
@Slf4j
public class TimeAdvice {
    @Around(value = "execution(* com.flab.dj.springannotation.RunCommand.*(..))")

    public Object methodCallTime(ProceedingJoinPoint pjp) throws Throwable {
        Instant start = Instant.now();
        log.info("<<[start] {}", pjp.getSignature().getName() + Arrays.toString(pjp.getArgs()));

        Object result = pjp.proceed();

        System.out.println("result=" + result); //

        Instant end = Instant.now();
        log.info("[end]>> {}", Duration.between(start,end).toMillis() + "ms");

        return result;
    }
}
