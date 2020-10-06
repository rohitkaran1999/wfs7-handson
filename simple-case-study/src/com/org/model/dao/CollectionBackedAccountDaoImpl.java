package com.org.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.org.model.beans.Account;

public class CollectionBackedAccountDaoImpl implements AccountDao {

	private static List<Account> database = new ArrayList<>();
	@Override
	public Account createAccount(Account account) {
		database.add(account);
		return account;
	}

	@Override
	public Account updateBalance(int accountNumber, double amount) {
		// TODO Auto-generated method stub
		List<Account> temp = database.stream().filter(account -> account.getAccountNumber()==accountNumber).collect(Collectors.toList());
		Account acc = temp.get(0);
		acc.setBalance(amount);
		return acc;
	}

	@Override
	public Account getAccount(int accountNumber) {
		// TODO Auto-generated method stub
		List<Account> temp = database.stream().filter(account -> account.getAccountNumber()==accountNumber).collect(Collectors.toList());
		Account acc = temp.get(0);
		return acc;
	}

	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return database;
	}

}
