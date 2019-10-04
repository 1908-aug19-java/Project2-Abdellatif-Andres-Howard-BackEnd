package com.revature.project2.dao;

import java.util.List;

import com.revature.project2.model.Account;

public interface AccountDao {
	public List<Account> getAccount();
	public int createAccount(Account account);

}
