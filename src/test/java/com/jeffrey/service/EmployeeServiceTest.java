package com.jeffrey.service;

import com.jeffrey.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description
 * @date 2018-6-4 23:08
 */
public class EmployeeServiceTest {
    private ApplicationContext context = null;
    private EmployeeService employeeService = null;
    @Before
    public void setup(){
        context = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = context.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        context = null;
        System.out.println("tearDown");
    }

    @Test
    public void testupdate(){
        employeeService.update(55,1);
    }
}
