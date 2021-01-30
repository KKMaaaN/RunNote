package com.kould.aspect;

import com.kould.utils.TransactionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

import java.util.Arrays;

@Aspect
@Component
public class ServiceTransactionalAop {
//    private Logger log = LoggerFactory.getLogger(ServiceTransactionalAop.class) ;

    @Autowired
    private TransactionUtils transactionUtils ;

    @Pointcut("execution(* com.kould.service..*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("");
        System.out.println("#######################################");
        System.out.println("##前置通知");
        System.out.println("##參數為: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("##後置通知");
    }

    @AfterReturning(value = "pointCut()" , returning = "result")
    public void afterReturing(JoinPoint joinPoint,Object result) {
        System.out.println("##執行結束后返回參數為: " + result.toString());
        System.out.println("#######################################");
        System.out.println("");
    }

    @AfterThrowing(value = "pointCut()" , throwing = "exception")
    public void throwException(JoinPoint joinPoint,Exception exception) {
        System.out.println("##異常通知" + exception.toString());
    }

    @Around("pointCut()")
    public Object arroundInvoke(ProceedingJoinPoint point) throws Throwable {
//        this.log.info(point.getArgs().toString());
        TransactionStatus begin = transactionUtils.begin() ;
        try {
            Object proceed = point.proceed();
            transactionUtils.commit(begin);
            return proceed;
        } catch (Exception e) {
            transactionUtils.rollback(begin);
            return "事务已回滚!";
        }
    }
}
