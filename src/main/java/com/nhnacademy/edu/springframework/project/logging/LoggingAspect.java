package com.nhnacademy.edu.springframework.project.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Around(value = "execution(* com.nhnacademy.edu.springframework.project..*(..))")
    private Object loggingSendMessageTime(ProceedingJoinPoint pjp) {
        StopWatch stopWatch = new StopWatch();
        Object retVal;
        try {
            stopWatch.start();
            retVal = pjp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            stopWatch.stop();
            String className = pjp.getTarget().getClass().getSimpleName();
            String methodName = pjp.getSignature().getName();
            String elapsedTime = stopWatch.getTotalTimeMillis() + "ms";
            log.info(className + "." + methodName + " " + elapsedTime);
        }

        return retVal;
    }
}

