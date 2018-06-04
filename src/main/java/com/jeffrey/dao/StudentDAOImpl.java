package com.jeffrey.dao;

import com.jeffrey.domain.Student;
import com.jeffrey.util.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description studentDAO访问接口实现类：通过最原始的JDBC的方式操作
 * @date 2018-6-3 21:27
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> query() {
        Connection connection=null;
        PreparedStatement prepareStatement=null;
        ResultSet resultSet=null;
        List<Student> studentList = new ArrayList<>();
        String sql = "select id,name,age from student";
        try {
            connection = JDBCUtil.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            Student student = null;
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                studentList.add(student);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet,prepareStatement,connection);
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        Connection connection=null;
        PreparedStatement prepareStatement=null;
        ResultSet resultSet=null;
        String sql = "insert into student(name,age) values (?,?)";
        try {
            connection = JDBCUtil.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1,student.getName());
            prepareStatement.setInt(2,student.getAge());
            prepareStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet,prepareStatement,connection);
        }
    }
}
