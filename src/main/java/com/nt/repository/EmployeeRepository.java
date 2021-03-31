package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.bo.EmployeeBO;

public interface EmployeeRepository extends CrudRepository<EmployeeBO, Integer>{

}
