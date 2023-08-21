package com.bivala.backend.service;

import com.bivala.backend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findByID(int id);
    Employee save(Employee employee);
    void delete(int id);
}
