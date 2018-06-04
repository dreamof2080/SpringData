package com.jeffrey.domain;

import javax.persistence.*;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description 雇员：先开发实体类===>自动生成数据表
 * @date 2018-6-3 22:40
 */
@Entity
@Table(name = "test_employee")
public class Employee {
    private Integer id;
    private String name;
    private Integer age;

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
