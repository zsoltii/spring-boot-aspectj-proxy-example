package hu.zsoltii.springboot.aspectj.example.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAccessAspect.class);

    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    @Before("execution(* hu.zsoltii.springboot.aspectj.example.data.*.*(..))")
    public void before(JoinPoint joinPoint){
        //Advice
        LOGGER.info(" Check for user access ");
        LOGGER.info(" Allowed execution for {}", joinPoint);
    }
}

