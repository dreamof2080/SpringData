package com.jeffrey.service;

import com.jeffrey.domain.Employee;
import com.jeffrey.repository.EmployeeCrudRepository;
import com.jeffrey.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description
 * @date 2018-6-4 23:06
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void update(Integer age,Integer id){
        employeeRepository.update(age,id);
    }

    @Transactional
    public void save(List<Employee> employees){
        employeeCrudRepository.save(employees);
    }
}
