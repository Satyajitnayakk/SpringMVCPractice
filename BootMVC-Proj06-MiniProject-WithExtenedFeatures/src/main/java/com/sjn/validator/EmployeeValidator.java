package com.sjn.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sjn.model.Employee;
@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {//To check correct modeel class is taken or not
		return clazz.isAssignableFrom(Employee.class);//if true then valdate method executes otherwise not
	}

	@Override
	public void validate(Object target, Errors errors) {//place the validation logic here
		//Type casting with model class
		Employee emp=(Employee) target;
		//form Validation logic(Server side) and place the errors in Errors object here
		if(emp.getEname()==null || emp.getEname().isBlank())//required rule
			errors.rejectValue("ename", "emp.name.required");
		else if(emp.getEname().length()<5 || emp.getEname().length()>15)//required rule
			errors.rejectValue("ename", "emp.name.length");
		if(emp.getJob()==null || emp.getJob().isBlank())//required rule
			errors.rejectValue("job", "emp.job.required");
		else if(emp.getJob().length()<5 || emp.getJob().length()>10)//required rule
			errors.rejectValue("job", "emp.job.length");
		
		if(!errors.hasFieldErrors("sal")) {
		if(emp.getSal()==null)
			errors.rejectValue("sal", "emp.salary.required");
		else if(emp.getSal()<10000 || emp.getSal()>500000)//required rule
			errors.rejectValue( "sal", "emp.salary.range");
		}
		
		if(emp.getDeptNo()==null) {
			errors.rejectValue("deptNo", "emp.deptno.required");
		}	
			
	}

}
