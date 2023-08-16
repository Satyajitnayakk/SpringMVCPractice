package com.sjn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sjn.model.Department;

public interface IDeparmentRepository extends CrudRepository<Department, Integer> {
    @Query("select deptno from Department")
    public List<Object[]> getAllDeptNo();
}
