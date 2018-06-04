package com.jeffrey.repository;

import com.jeffrey.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description
 * @date 2018-6-4 21:32
 */
public class EmployeeJpaRepositoryTest {
    private ApplicationContext context = null;
    private EmployeeJpaRepository employeeJpaRepository = null;
    @Before
    public void setup(){
        context = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository = context.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        context = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFind(){
        Employee employee = employeeJpaRepository.findOne(99);
        System.out.println(employee);

        System.out.println(employeeJpaRepository.exists(10));
        System.out.println(employeeJpaRepository.exists(102));
    }

}
