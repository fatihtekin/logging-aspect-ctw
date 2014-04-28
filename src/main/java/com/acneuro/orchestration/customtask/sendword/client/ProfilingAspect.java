package com.acneuro.orchestration.customtask.sendword.client;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Aspect
public class ProfilingAspect {
    private static final Logger log = LoggerFactory.getLogger(ProfilingAspect.class);

    @Around(value = "methodsToBeProfiled(workItem,workItem2)", argNames = "pjp,workItem,workItem2"   )
    public Object profile(ProceedingJoinPoint pjp, String workItem,String workItem2) throws Throwable {
    	System.out.println("============================================asdasdadadsd");
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("ActionId=[" + workItem + "]");
        sb.append(" State=[" + workItem+ "]");
        MDC.put("ENGINE_ID", sb.toString());
        try {
            return pjp.proceed();
        } finally {
            long end = System.currentTimeMillis();
            log.info(" Action processed in [" + (end - start) + "] millis.");
            MDC.remove("ENGINE_ID");
        }
    }

    //@Pointcut("execution(public * com.acneuro.orchestration.customtask.sendword.client.SendWordWorkItemHandler.*(..))")
    //@Pointcut ( "within(om.acneuro.orchestration.customtask.sendword.client.*)" )
    @Pointcut("execution(public * com.acneuro.orchestration.customtask.sendword.client.SendWordWorkItemHandler.*(..)) && args(workItem,workItem2)")
    public void methodsToBeProfiled(String workItem,String workItem2) {
    }

}