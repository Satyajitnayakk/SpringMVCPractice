package com.sjn.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sjn.model.Employee;

public interface IEmployeeManagementService {
   public Iterable<Employee> getAllEmployees();
   public String saveEmployee(Employee emp);
   public Employee getEmployeeByNo(int empno);
   public String deleteEmployeeById(int empno);
   public String updateEmployeee(Employee emp);
   public List<Object[]> getAllEmployeeId();
   public boolean isDesginationRejected(String desg);
   public Page<Employee> getAllEmoloyeeByPage(Pageable pageable);
}
