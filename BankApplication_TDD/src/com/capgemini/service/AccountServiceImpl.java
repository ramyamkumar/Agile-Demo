package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository)
	{
		this.accountRepository=accountRepository;
	}
	public Account createAccount(int accountNumber,int amount)throws InsufficientInitialAmountException
	{
		if(amount<500)
		{
			throw new InsufficientInitialAmountException();
		}
		Account account =new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);

		if(accountRepository.save(account))
		{
			return account;
		}

		return null;

	}

	public int withDrawAmount (int accountNumber,int amount,int drawnAmount) throws InsufficientBalanceException
	{
		if(amount < drawnAmount ){
			throw new InsufficientBalanceException();

		}
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		account.setDrawnAmount(drawnAmount);

		if(accountRepository.withDrawAmount(amount)){
			return amount;
		}

		return drawnAmount;
	}

	public boolean searchAccount(int accountNumber){
		Account account = new Account();
		account.setAccountNumber(accountNumber);	

		if(accountRepository.equals(accountNumber)){
			return true;
		}
		return false;


	}


}