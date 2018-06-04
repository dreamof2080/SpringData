package com.jeffrey.repository;

import com.jeffrey.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description
 * @date 2018-6-4 23:31
 */
public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer> {
}
