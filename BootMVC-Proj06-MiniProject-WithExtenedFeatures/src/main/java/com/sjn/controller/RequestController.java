package com.sjn.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sjn.model.Employee;
import com.sjn.service.EmployeeManagementService;
import com.sjn.validator.EmployeeValidator;


@Controller
public class RequestController {
	@Autowired
	EmployeeManagementService service;
	@Autowired
	EmployeeValidator empValidator;
	
	
	@GetMapping("/")
	public String showWelcomeFile() {
		return "welcome";
	}
	@GetMapping("/emp_add")
	public String showEmloyeeResgForm(@ModelAttribute("emp")Employee emp) {
		return "resister_employee";
	}
	@GetMapping("/emp_report")
	public String addEmployee(@PageableDefault(page=0,size=3,sort="job")Pageable pageable,Map<String,Object> map) {
		System.out.println("RequestController.addEmployee()");
		Page<Employee> page=service.getAllEmoloyeeByPage(pageable);
		map.put("emp_details", page);
		return "show_employee_report";
	}
	
	@PostMapping("/emp_add")
	public String shoeEmployee(RedirectAttributes attrs,@ModelAttribute("emp")Employee emp,BindingResult errors){
	  if(emp.getvFlag().equalsIgnoreCase("no")) {	
		
		if(empValidator.supports(Employee.class)) {
			empValidator.validate(emp, errors);
			if(service.isDesginationRejected(emp.getJob()))
				errors.rejectValue("job", "emp.job.reject");
			if(errors.hasErrors())
				return "resister_employee";	
		}//if
	  }	
	    
		//use service	
		String msg=service.saveEmployee(emp);
		//keep the result in flash attribute
		attrs.addFlashAttribute("Result_msg", msg);
		return "redirect:emp_report";	
	}
	
	@GetMapping("/error_page")
	public String displayTypeMismatchError() {
		return "error_page";
	}
	
	
	@GetMapping("/emp_delete")
	public String deleteEmp(RedirectAttributes attrs,@RequestParam int no) {
		//use service
		String msg=service.deleteEmployeeById(no);
		attrs.addFlashAttribute("Result_msg", msg);
		return "redirect:emp_report";
	}
	@GetMapping("/emp_edit")
	public String editEmplyeebyId(@ModelAttribute("emp")Employee emp,@RequestParam int no) {
		//get the Employee object by given id
		Employee emp1=service.getEmployeeByNo(no);
		//copy the data
		BeanUtils.copyProperties(emp1, emp);
		return "update_employee";
	}
	@PostMapping("/emp_edit")
	public String editEmployee(RedirectAttributes attrs,@ModelAttribute("emp")Employee emp,BindingResult errors) {
		if(emp.getvFlag().equalsIgnoreCase("no")) {		
		if(empValidator.supports(Employee.class)) {
			empValidator.validate(emp, errors);
			if(errors.hasErrors())
				return "update_employee";
		}	
		}//if
		String msg=service.updateEmployeee(emp);
		attrs.addFlashAttribute("Result_msg", msg);
		return "redirect:emp_report";
	}
	
	@ModelAttribute("DeptInfo")
	public List<Object[]> RefDataForDeptNoSelectBox(){
		return service.getAllEmployeeId();
	}
	

}
