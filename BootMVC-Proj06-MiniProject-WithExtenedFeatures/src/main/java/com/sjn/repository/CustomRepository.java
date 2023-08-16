package com.sjn.repository;

import com.sjn.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomRepository extends PagingAndSortingRepository<Employee,Integer>,CrudRepository<Employee,Integer> {

}
