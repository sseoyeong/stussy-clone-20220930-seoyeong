package com.stussy.stussyclone20220930seoyeong.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Slf4j
@Aspect
@Component
public class LogAop {

    @Pointcut("execution(* com.stussy.stussyclone20220930seoyeong.api.*Api.*(..))")
    private void pointCut() {}

    @Pointcut("@Annotation(com.stussy.stussyclone20220930seoyeong.aop.annotation.LogAspect)")
    private void annotationPointCut() {}

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();

        String className = codeSignature.getDeclaringTypeName();
        String methodName = codeSignature.getName();
        String[] parameterNames = codeSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();

        for(int i = 0; i < parameterNames.length; i++) {
            log.info("<<<< Parameter info >>>> {}.{} >>> [{}: {}]", className, methodName, parameterNames[i], args[i]);
        }

        Object result = joinPoint.proceed();

        log.info("<<<< Return >>>> {}.{} >>> [{}]", className, methodName, result);

        return result;
    }

}
