package com.revature.project2.dao;

import org.hibernate.Session;

import com.revature.project2.model.AccountInfo;
import com.revature.project2.util.HibernateUtil;

public class AccountInfoDaoImpl implements AccountInfoDao {

	@Override
	public AccountInfo getAccountInfoById(int i) {
		try(Session s = HibernateUtil.getSession()){
			AccountInfo b = s.get(AccountInfo.class, i);
			return b;
	}
	}
}
