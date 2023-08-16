package com.sjn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sjn.model.Employee;
import com.sjn.repository.CustomRepository;
import com.sjn.repository.IDeparmentRepository;
@Service
public class EmployeeManagementService implements IEmployeeManagementService {
    @Autowired
    CustomRepository repo;
    @Autowired
    IDeparmentRepository repo2;
	@Override
	public Iterable<Employee> getAllEmployees() {
		Iterable<Employee> emp=repo.findAll();
		return emp;
	}
	@Override
	public String saveEmployee(Employee emp) {
		return "Employee is saved with id value"+repo.save(emp).getEno();
	}
	@Override
	public Employee getEmployeeByNo(int empno) {
		Employee emp=repo.findById(empno).orElseThrow(()->new IllegalArgumentException("Record not found"));
		return emp;
	}
	@Override
	public String deleteEmployeeById(int empno) {
		repo.deleteById(empno);
		return "Employee Record has been deleted";
	}
	@Override
	public String updateEmployeee(Employee emp) {
		return "Employee is updated with id:: "+repo.save(emp).getEno();
	}
	//method for adding reference data dptNo coloum
	@Override
	public List<Object[]> getAllEmployeeId() {
		List<Object[]> list=repo2.getAllDeptNo();
		return list;
	}
	//method for application logic errors 
	@Override
	public boolean isDesginationRejected(String desg) {
		if(desg.equalsIgnoreCase("TeamLeader"))
			return true;
		else
		    return false;
	}
	//method for retrieving all records by page by sending pageable object having pagesize , pageno and sort as input
	@Override
	public Page<Employee> getAllEmoloyeeByPage(Pageable pageable) {
		return repo.findAll(pageable);
	}
    
}
