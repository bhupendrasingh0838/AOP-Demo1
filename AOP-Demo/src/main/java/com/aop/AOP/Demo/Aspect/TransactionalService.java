package com.aop.AOP.Demo.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionalService {


    @Pointcut("@annotation(com.aop.AOP.Demo.Annotation.TransactionAnno)")  //Annotation Based PointCut
                            //OR
  // @Pointcut("execution(public String com.aop.AOP.Demo.Dao.EmployeeDAO.saveEmployee())") //Normal Linking of the business class
    public void p1() {
    }

    //advice
    @Before(("p1()"))  //JoinPoint
    public void beginTx() {
        System.out.println("Tx started..!!");
    }

    @After("p1()")
    public void sendReport() {
        System.out.println("Report Send..!!");
    }

    @AfterReturning(value = "p1()", returning = "ob")
    public void commitTx(Object ob) {
        System.out.println("Transaction is committed. " + ob);
    }

    @AfterThrowing(value = "p1()", throwing = "th")
    public void rollBack(Throwable th) {
        System.out.println("Transaction is RollBack.  " + th.getMessage());
    }
    @Pointcut("execution(* com.aop.AOP.Demo.Dao.EmployeeDAO.aroundSave() )")
    public void p2() {
    }

    @Around("p2()")
    public void aroundTest(ProceedingJoinPoint joinPoint) {
        System.out.println("-----------< AROUND ADVICE >-----------------");
        System.out.println("Before Business Method");
        // code ---> call Business Method
        try {
            //On success
            Object ob = joinPoint.proceed();
            System.out.println("Data is " + ob);
        } catch (Throwable e) {
            // On failure
            e.printStackTrace();
        }
        System.out.println("After Business Method");
    }
}
