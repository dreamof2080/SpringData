package com.jeffrey.dao;

import com.jeffrey.domain.Student;

import java.util.List;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description studenDAO访问接口
 * @date 2018-6-3 21:26
 */
public interface StudentDAO {

    /**
     * 查询所有学生
     * @return 所有学生
     */
    public List<Student> query();

    public void save(Student student);
}
