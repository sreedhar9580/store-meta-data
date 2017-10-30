package com.app.spring.boot.storemetadata.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import autovalue.shaded.org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int age;
	private int salary;
	private String designation;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Override
	public String toString() {
		return new StringBuffer(" EmployeeID : ").append(this.id).append(" Name : ").append(this.name).append(" Age : ").append(this.age).append(" Salary : ").append(this.salary).append(" Designation : ").append(this.designation).toString();
	}

}
