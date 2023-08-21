package com.bivala.backend.rest;

import com.bivala.backend.dao.EmployeeDAO;
import com.bivala.backend.entity.Employee;
import com.bivala.backend.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee theEmployee=employeeService.findByID(id);
        if(theEmployee==null){
            throw new RuntimeException("Employee is not exist - id: "+id);
        }
        return theEmployee;
    }
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee theEmployee,@PathVariable int id){
        theEmployee.setId(id);
        return employeeService.save(theEmployee);
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee=employeeService.findByID(id);
        if(employee==null){
            throw new RuntimeException("Employee is not exist - id:"+id);
        }
        employeeService.delete(id);
        return "Successful delete employee with ID: "+id;
    }
}
