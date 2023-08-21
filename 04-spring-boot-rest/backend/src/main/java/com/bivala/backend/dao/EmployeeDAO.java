package com.bivala.backend.dao;

import com.bivala.backend.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findByID(int id);
    Employee save(Employee employee);
    void deleteByID(int id);

}
