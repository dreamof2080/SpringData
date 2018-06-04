package com.jeffrey.repository;

import com.jeffrey.domain.Employee;
import com.jeffrey.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description
 * @date 2018-6-4 21:32
 */
public class EmployeeCrudRepositoryTest {
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
    public void testSave(){
        List<Employee> employeeList = new ArrayList<>();
        Employee employee;
        for (int i = 0; i < 100; i++) {
            employee = new Employee();
            employee.setName("test"+i);
            employee.setAge(100 - i);
            employeeList.add(employee);
        }
        employeeService.save(employeeList);
    }
}
