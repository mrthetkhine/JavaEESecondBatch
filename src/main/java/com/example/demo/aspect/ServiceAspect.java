package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ServiceAspect {

	@Before("execution(* com.example.demo.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        //Advice
      System.out.println("Advice Before Run ");
    }
}
