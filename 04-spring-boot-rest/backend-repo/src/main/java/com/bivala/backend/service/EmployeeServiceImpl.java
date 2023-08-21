package com.bivala.backend.service;

import com.bivala.backend.dao.EmployeeRepository;
import com.bivala.backend.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepo;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public EmployeeServiceImpl() {
    }

    @Override
    public List<Employee> findAll() {

        return employeeRepo.findAll();
    }

    public Employee findById(Integer id) {
        Optional<Employee> result= employeeRepo.findById(id);
        if(result.isEmpty()){
            throw new RuntimeException("Employee is not exist - ID: "+id);
        }
        return result.get();
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        employeeRepo.deleteById(id);
    }
}
