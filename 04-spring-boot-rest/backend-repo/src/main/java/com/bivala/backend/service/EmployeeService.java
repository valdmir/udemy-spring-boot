package com.bivala.backend.service;

import com.bivala.backend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Integer id);
    Employee save(Employee employee);
    void delete(Integer id);
}
