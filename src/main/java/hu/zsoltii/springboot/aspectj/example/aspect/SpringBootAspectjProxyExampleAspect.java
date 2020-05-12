package hu.zsoltii.springboot.aspectj.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class SpringBootAspectjProxyExampleAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootAspectjProxyExampleAspect.class);

    private static final String FILTER = "execution(* hu.zsoltii.springboot.aspectj.example.data.*.*(..))";

    @After(FILTER)
    public void after(JoinPoint joinPoint){
        LOGGER.info("After execution for {}", joinPoint.getSignature());
    }

    @Around(FILTER)
    public Object auditLogAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("Called before proceed: {}", joinPoint.getSignature());
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        double runningTime = (double) (System.currentTimeMillis() - start) / 1000.0;
        LOGGER.info("Called after proceed: [running time: {}s][result: {}][signature: {}]", runningTime, result, joinPoint.getSignature());
        return result;
    }

    @Before(FILTER)
    public void before(JoinPoint joinPoint){
        LOGGER.info("Before execution for {}", joinPoint.getSignature());
    }
}

