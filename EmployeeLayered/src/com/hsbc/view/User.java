/**
 * 
 */
package com.hsbc.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.hsbc.dao.EmployeeDAOImpl;
import com.hsbc.model.Employee;

/**
 * @author Rohitkaran
 *
 */
public class User {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int option;
		do {
			System.out.println("Menu:");
			System.out.println("----------------------------");
			System.out.println("1. Store Employee Data");
			System.out.println("2. Dipslay employee data");
			System.out.println("3. Exit");


			option = scan.nextInt();
			switch(option) {
			case 1:
				Employee emp = null;
				System.out.println("Enter Employee ID :");
				int empID=scan.nextInt();
				System.out.println("Enter Employee Name :");
				String name = scan.next();
				System.out.println("Enter Employee salary :");
				double amt = scan.nextDouble();
				System.out.println("Enter employee date-of-birth in dd-MM-yyyy format :");
				String date = scan.next();
				LocalDate birthdate = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				emp = new Employee(empID,name,amt,birthdate);
				new EmployeeDAOImpl().storeEmp(emp);
				break;
			case 2:
				int sortBasis;
				System.out.println("On what basis do you wish to display the data :");
				System.out.println("1. Ascending order with ID");
				System.out.println("2. Descending order with ID");
				System.out.println("3. Ascending order with Name");
				System.out.println("4. Descending order with Name");
				sortBasis = scan.nextInt();
				List<Employee> list = new EmployeeDAOImpl().getTop3(sortBasis);
				System.out.println(list);
				break;
			case 3:
				break;
			default:
				System.out.println("Wrong option selected");
			}
		} while(option !=3);
		
		scan.close();

	}
}
