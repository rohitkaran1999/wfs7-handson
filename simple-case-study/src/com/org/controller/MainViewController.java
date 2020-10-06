package com.org.controller;

import java.util.List;
import java.util.Scanner;

import com.org.model.beans.Account;
import com.org.model.service.AccountService;
import com.org.model.util.ObjectFactory;

public class MainViewController {

	public static void main(String[] args) {
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		AccountService service = ObjectFactory.getAccountServiceInstance();
		do {
			System.out.println("1: Create Account 2: Check Balance");
			System.out.println("3: Transfer Amount 4: Sort Accounts by name 5: Sort Accounts by account number 0: Exit");
			option = scanner.nextInt();
			List<Account> list = null;
			switch(option) {
			case 1: 
				System.out.println("Enter name");
				Account account = new Account(scanner.next());
				Account createdAccount = service.createAccount(account);
				System.out.println(createdAccount);
				break;
			case 2: 
				System.out.println("Enter the account number");
				Double balance = service.getBalance(scanner.nextInt());
				System.out.println("The balance for the given account number is "+ balance);
				break; 
			case 3: 
				System.out.println("Enter the source account number :");
				int acc1 = scanner.nextInt();
				System.out.println("Enter the destination account number :");
				int acc2 = scanner.nextInt();
				System.out.println("Enter the amount :");
				service.transfer(acc1, acc2, scanner.nextDouble());
				System.out.println("The destination account has been deposited from the source account with the specified amount ");
				break; 
			case 4: 
				list = service.getAccountsSortedByName(); // HttpSession -> setAttribute("key", list) -> ${ }
				list.forEach(acc -> System.out.println(acc));
				break;
			case 5:
				list = service.getAccountsSortedByAccountNumber();
				list.forEach(acc3 -> System.out.println(acc3));
				break;
			}
		} while(option != 0);
		
		scanner.close();
	}

}

