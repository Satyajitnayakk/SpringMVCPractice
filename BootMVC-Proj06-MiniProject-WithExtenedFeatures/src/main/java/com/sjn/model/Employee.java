package com.sjn.model;

import java.io.Serializable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
@Entity
@Table(name="boot_employee")
@Data
@SQLDelete(sql="UPDATE BOOT_EMPLOYEE SET STATUS='deleted' WHERE ENO=?")
@Where(clause="STATUS <> 'deleted'")
public class Employee implements Serializable {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "emp_id_seq2",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy = GenerationType.SEQUENCE)
	private Integer eno;
	@Column(length=20,name="Emloyee Name")
	private String ename;
	@Column(length=20,name="Desgination")
	private String job;
	@Column(name="Salary")
	private Float sal;
	@Column(name="Deparment No")
    private Integer deptNo;
	private String Status="active";
	@Transient
	private String vFlag="no";
	public String getvFlag() {
		return vFlag;
	}
	public void setvFlag(String vFlag) {
		this.vFlag = vFlag;
	}
	
}
