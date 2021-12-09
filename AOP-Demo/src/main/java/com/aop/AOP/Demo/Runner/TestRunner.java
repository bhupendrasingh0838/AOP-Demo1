package com.aop.AOP.Demo.Runner;

import com.aop.AOP.Demo.Dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {
    @Autowired
    EmployeeDAO employeeDAO;
    @Override
    public void run(String... args) throws Exception {
        employeeDAO.saveEmployee();
        employeeDAO.aroundSave();
    }

}
