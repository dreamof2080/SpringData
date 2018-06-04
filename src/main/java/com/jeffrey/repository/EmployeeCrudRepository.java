package com.jeffrey.repository;

import com.jeffrey.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description
 * @date 2018-6-4 23:18
 */
public interface EmployeeCrudRepository extends CrudRepository<Employee,Integer> {
}
