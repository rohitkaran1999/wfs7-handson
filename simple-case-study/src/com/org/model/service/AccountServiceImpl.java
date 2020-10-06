package com.org.model.service;

import java.util.List;
import java.util.stream.Collectors;

import com.org.model.beans.Account;
import com.org.model.dao.AccountDao;
import com.org.model.util.ObjectFactory;

public class AccountServiceImpl implements AccountService {

	
	private AccountDao accountDao = null;
	public AccountServiceImpl() {
		accountDao = ObjectFactory.getAccountDaoInstance();
	}
	
	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDao.createAccount(account);
	}

	@Override
	public double getBalance(int accountNumber) {
		// TODO Auto-generated method stub
		Account acc = accountDao.getAccount(accountNumber);
		double balance = acc.getBalance();
		return balance;
	}

	@Override
	public void transfer(int sourceAccount, int destinationAccount, double amount) {
		// TODO Auto-generated method stub
		Account acc1 = accountDao.getAccount(sourceAccount);
		Account acc2 = accountDao.getAccount(destinationAccount);
		Double currBal1 = acc1.getBalance();
		Double currBal2 = acc2.getBalance();
		accountDao.updateBalance(sourceAccount, currBal1 - amount);
		accountDao.updateBalance(destinationAccount, amount + currBal2);
	}

	@Override
	public List<Account> getAccountsSortedByName() {
		List<Account> accounts = accountDao.getAccounts();
		List<Account> sortedAccount = accounts.stream()
		.sorted((account1, account2) -> account1.getCustomerName().compareTo(account2.getCustomerName()))
		.collect(Collectors.toList());
		
		return sortedAccount;
	}

	@Override
	public List<Account> getAccountsSortedByAccountNumber() {
		// TODO Auto-generated method stub
		List<Account> accounts = accountDao.getAccounts();
		List<Account> sortedAccount = accounts.stream()
		.sorted((account1, account2) -> account1.getAccountNumber()-account2.getAccountNumber())
		.collect(Collectors.toList());
		return sortedAccount;
	}

}
