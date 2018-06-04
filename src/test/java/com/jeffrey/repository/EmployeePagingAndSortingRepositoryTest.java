package com.jeffrey.repository;

import com.jeffrey.domain.Employee;
import com.jeffrey.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description
 * @date 2018-6-4 21:32
 */
public class EmployeePagingAndSortingRepositoryTest {
    private ApplicationContext context = null;
    private EmployeePaginAndSortingRepository employeePaginAndSortingRepository = null;
    @Before
    public void setup(){
        context = new ClassPathXmlApplicationContext("beans-new.xml");
        employeePaginAndSortingRepository = context.getBean(EmployeePaginAndSortingRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        context = null;
        System.out.println("tearDown");
    }

    @Test
    public void testPage(){
        //page:index是从0开始的，不是从1开始的
        Pageable pageable = new PageRequest(0,5);
        Page<Employee> employeePage = employeePaginAndSortingRepository.findAll(pageable);
        System.out.println("查询的总页数"+employeePage.getTotalPages());
        System.out.println("查询的总记录数"+employeePage.getTotalElements());
        System.out.println("查询的当前第几页"+employeePage.getNumber()+1);
        System.out.println("查询的当前页面的集合"+employeePage.getContent());
        System.out.println("查询的当前页面的记录数"+employeePage.getNumberOfElements());
    }

    @Test
    public void testPageAndSort(){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);
        //page:index是从0开始的，不是从1开始的
        Pageable pageable = new PageRequest(0,5,sort);
        Page<Employee> employeePage = employeePaginAndSortingRepository.findAll(pageable);
        System.out.println("查询的总页数"+employeePage.getTotalPages());
        System.out.println("查询的总记录数"+employeePage.getTotalElements());
        System.out.println("查询的当前第几页"+employeePage.getNumber()+1);
        System.out.println("查询的当前页面的集合"+employeePage.getContent());
        System.out.println("查询的当前页面的记录数"+employeePage.getNumberOfElements());
    }

}
