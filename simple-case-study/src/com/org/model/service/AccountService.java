package com.org.model.service;

import java.util.List;

import com.org.model.beans.Account;

public interface AccountService {
	public Account createAccount(Account account);
	public double getBalance(int accountNumber);
	// call updateBalance() on source & destination account
	public void transfer(int sourceAccount, int destinationAccount, double amount);
	public List<Account> getAccountsSortedByName();
	public List<Account> getAccountsSortedByAccountNumber();
}
