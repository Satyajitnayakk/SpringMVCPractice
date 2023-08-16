package com.sjn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name="Department")
public class Department {
	@Id
   private Integer deptno;
   private String deptname;
   private String loc;
}
