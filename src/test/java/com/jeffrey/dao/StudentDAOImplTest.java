package com.jeffrey.dao;

import com.jeffrey.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description
 * @date 2018-6-3 21:34
 */
public class StudentDAOImplTest {

    @Test
    public void testQuery(){
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();
        for (Student student : students) {
            System.out.println("id:"+student.getId()+",name:"+student.getName()+",age:"+student.getAge());
        }
    }

    @Test
    public void testSave(){
        Student student = new Student();
        student.setAge(30);
        student.setName("test");
        StudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.save(student);
    }
}
