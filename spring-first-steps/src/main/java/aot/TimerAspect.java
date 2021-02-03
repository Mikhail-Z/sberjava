package aot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimerAspect {

    @Around("execution()")
    public Object invocationTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        //some login
        try {
            return joinPoint.proceed();
        }
        finally {
            System.out.println("method passed in " + (System.nanoTime() - startTime));
        }
    }
}
