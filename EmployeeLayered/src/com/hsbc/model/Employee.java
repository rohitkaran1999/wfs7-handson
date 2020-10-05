/**
 * 
 */
package com.hsbc.model;

import java.time.LocalDate;

/**
 * @author Rohitkaran
 *
 */
public class Employee {
	
	private int empID;
	private String empName;
	private double empSalary;
	private LocalDate empBirthdate;
	
	public Employee() {
		super();
	}

	public Employee(int empID, String empName, double empSalary, LocalDate empBirthdate) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empBirthdate = empBirthdate;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public LocalDate getEmpBirthdate() {
		return empBirthdate;
	}

	public void setEmpBirthdate(LocalDate empBirthdate) {
		this.empBirthdate = empBirthdate;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empSalary=" + empSalary + ", empBirthdate="
				+ empBirthdate + "]";
	}
	
}
