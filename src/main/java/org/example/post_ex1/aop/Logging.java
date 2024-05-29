package org.example.post_ex1.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class Logging {

    @Before("execution(* org.example.post_ex1.controller.*.*(..))")
    public void leaveLog(JoinPoint jp){
        String className = jp.getTarget().getClass().getName();
        String methodName = jp.getSignature().getName();
        log.info("{} - {} 가 실행되기 전 로그" , className, methodName);
    }
}
