package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data

	private EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService){
		this.employeeService=employeeService;
	}
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployees=employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Employee theEmployee=new Employee();
		theModel.addAttribute("employee",theEmployee);
		return "employees/employee-form";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee theEmployee){
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId")int employeeId,Model theModel){
		Employee theEmployee=employeeService.findById(employeeId);
		theModel.addAttribute("employee",theEmployee);
		return "employees/employee-form";

	}
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int employeeId){
		employeeService.deleteById(employeeId);
		return "redirect:/employees/list";
	}
}

//
//	private List<Employee> theEmployees;
//
//	@PostConstruct
//	private void loadData() {
//
//		// create employees
//		Employee emp1 = new Employee("Leslie", "Andrews", "leslie@luv2code.com");
//		Employee emp2 = new Employee("Emma", "Baumgarten", "emma@luv2code.com");
//		Employee emp3 = new Employee("Avani", "Gupta", "avani@luv2code.com");
//
//		// create the list
//		theEmployees = new ArrayList<>();
//
//		// add to the list
//		theEmployees.add(emp1);
//		theEmployees.add(emp2);
//		theEmployees.add(emp3);
//	}









