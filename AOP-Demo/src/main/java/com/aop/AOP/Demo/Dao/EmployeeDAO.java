package com.aop.AOP.Demo.Dao;

import com.aop.AOP.Demo.Annotation.TransactionAnno;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EmployeeDAO {

    @TransactionAnno    //this annotation is created By Transaction Anno class
    public String saveEmployee() {
        System.out.println("FROM SAVE EMPLOYEE");

       /* if(new Random().nextInt(15)<=10){
            throw new RuntimeException("DUMMY EXCEPTION");
        }*/
            return " Hello";
        }
    public String aroundSave(){
        System.out.println("From Around Save Method");
        return "Hello Around Advice";
    }
}
