/**
 * 
 */
package com.hsbc.dao;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.model.Employee;

/**
 * @author Rohitkaran
 *
 */
public interface EmployeeDAO {
	
	void storeEmp(Employee employee);
	List<Employee> getEmployee(int sortBasis);
	List<Employee> getTop3(int sortBasis);

}
