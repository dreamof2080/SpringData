package com.jeffrey.repository;

import com.jeffrey.domain.Employee;
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
public class EmployeeRepositoryTest {
    private ApplicationContext context = null;
    private EmployeeRepository employeeRepository = null;
    @Before
    public void setup(){
        context = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = context.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        context = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFindByName(){
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println(employee.getId());
    }

    @Test
    public void testfindByNameStartingWithAndAgeLessThan(){
        List<Employee> employeeList = employeeRepository.findByNameStartingWithAndAgeLessThan("test",22);
        for (Employee employee : employeeList) {
            System.out.println(employee.getName());
        }
    }

    @Test
    public void testfindByNameEndingWithAndAgeLessThan(){
        List<Employee> employeeList = employeeRepository.findByNameEndingWithAndAgeLessThan("6",23);
        for (Employee employee : employeeList) {
            System.out.println(employee.getName());
        }
    }

    @Test
    public void testfindByNameInOrAgeLessThan(){
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employeeList = employeeRepository.findByNameInOrAgeLessThan(names,21);
        for (Employee employee : employeeList) {
            System.out.println(employee.getName());
        }
    }

    @Test
    public void testfindByNameInAndAgeLessThan(){
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employeeList = employeeRepository.findByNameInAndAgeLessThan(names,21);
        for (Employee employee : employeeList) {
            System.out.println(employee.getName());
        }
    }

    @Test
    public void testgetEmployeeByMaxId(){
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println(employee.getName());
    }

    @Test
    public void testqueryParams1(){
        List<Employee> employeeList = employeeRepository.queryParams1("test1",20);
        for (Employee employee : employeeList) {
            System.out.println(employee.getName());
        }
    }

    @Test
    public void testqueryParams2(){
        List<Employee> employeeList = employeeRepository.queryParams2("test1",20);
        for (Employee employee : employeeList) {
            System.out.println(employee.getName());
        }
    }

    @Test
    public void testqueryLike1(){
        List<Employee> employeeList = employeeRepository.queryLike1("test1");
        for (Employee employee : employeeList) {
            System.out.println(employee.getName());
        }
    }

    @Test
    public void testqueryLike2(){
        List<Employee> employeeList = employeeRepository.queryLike2("test1");
        for (Employee employee : employeeList) {
            System.out.println(employee.getName());
        }
    }

    @Test
    public void testgetCount(){
        Long count = employeeRepository.getCount();
        System.out.println(count);
    }

    @Test
    public void testupdate(){
        employeeRepository.update(1,55);
    }
}
