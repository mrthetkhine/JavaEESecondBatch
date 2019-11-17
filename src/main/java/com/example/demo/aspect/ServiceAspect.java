package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ServiceAspect {

	@Before("execution(* com.example.demo.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        //Advice
      System.out.println("Advice Before Run "+joinPoint);
    }
	/*
	@After("execution(* com.example.demo.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        //Advice
      System.out.println("Advice After Run "+joinPoint);
    }
    */
	/*
	@Around("execution(* com.example.demo.service.*.*(..))")
    public void around(ProceedingJoinPoint joinPoint) {
        //Advice
      System.out.println("Around Before Run ");
      try {
		joinPoint.proceed();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      System.out.println("Around After Run ");
    }
	*/
	@AfterReturning(value = "execution(* com.example.demo.service.*.*(..))", 
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
    	System.out.println("{} returned with value {}"+ joinPoint+ result);
    	System.out.println("Return result "+result);
	}
	@AfterThrowing(value= "execution(* com.example.demo.service.*.*(..))", throwing= "exception")
    public void afterThrowingAdvice(JoinPoint jp, Throwable exception) {
        System.out.println("Inside afterThrowingAdvice() method....= " + jp.getSignature().getName() + " method");
        System.out.println("Exception= " + exception);
    }
}
