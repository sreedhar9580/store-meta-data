package com.app.spring.boot.storemetadata.dao;

import org.springframework.data.repository.CrudRepository;
import com.app.spring.boot.storemetadata.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
