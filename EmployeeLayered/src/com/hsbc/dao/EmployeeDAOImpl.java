/**
 * 
 */
package com.hsbc.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.hsbc.model.Employee;

/**
 * @author Rohitkaran
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO{
	
	public static List<Employee> list = new ArrayList<Employee>();

	@Override
	public void storeEmp(Employee employee) {
		// TODO Auto-generated method stub
		
		list.add(employee);
		
	}

	@Override
	public List<Employee> getEmployee(int sortBasis) {
		
		List<Employee> tempList = new ArrayList<Employee>();
		tempList = list;
		
		if(sortBasis==1) {
			Collections.sort(tempList, (e1, e2) -> e1.getEmpID() - e2.getEmpID());
		}
		if (sortBasis==2) {
			Collections.sort(tempList, (e1, e2) -> e2.getEmpID() - e1.getEmpID());
		}
		if(sortBasis==3) {
			Collections.sort(tempList, (e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName()));
		}
		if(sortBasis==4){
			Collections.sort(tempList, (e1, e2) -> e2.getEmpName().compareTo(e1.getEmpName()));
		}
		return tempList;
	}

	@Override
	public List<Employee> getTop3(int sortBasis) {
		// TODO Auto-generated method stub
		
		List<Employee> list = new EmployeeDAOImpl().getEmployee(sortBasis);
		List<Employee> top3 = new ArrayList<Employee>();
		int counter = 0;
		for(Employee emp : list) {
			top3.add(emp);
			counter++;
			if(counter == 3)
				break;
		}
		return top3;
	}

}
