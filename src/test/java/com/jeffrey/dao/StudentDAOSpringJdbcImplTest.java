package com.jeffrey.dao;

import com.jeffrey.domain.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description
 * @date 2018-6-3 21:34
 */
public class StudentDAOSpringJdbcImplTest {
    private ApplicationContext context = null;
    private StudentDAO studentDAO = null;
    @Before
    public void setup(){
        context = new ClassPathXmlApplicationContext("beans.xml");
        studentDAO = (StudentDAO)context.getBean("studentDAO");
        System.out.println("setup");
    }

    @Test
    public void testQuery(){
        List<Student> students = studentDAO.query();
        for (Student student : students) {
            System.out.println("id:"+student.getId()+",name:"+student.getName()+",age:"+student.getAge());
        }
    }

    @Test
    public void testSave(){
        Student student = new Student();
        student.setName("test2");
        student.setAge(40);
        studentDAO.save(student);
    }
}
