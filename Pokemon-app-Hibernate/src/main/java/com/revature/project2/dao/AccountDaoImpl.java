package com.revature.project2.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.project2.model.Account;
import com.revature.project2.util.HibernateUtil;

public class AccountDaoImpl implements AccountDao{

	@Override
	public List<Account> getAccount() {
		Session s = HibernateUtil.getSession();
		
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Account> cq = cb.createQuery(Account.class);
		
		Root<Account> root = cq.from(Account.class);
		cq.select(root);
		
		Query<Account> query = s.createQuery(cq);
		List<Account> accounts = query.list();
		
		s.close();
		return accounts;
	}

	@Override
	public int createAccount(Account account) {
		int pk = 0;
		try (Session s = HibernateUtil.getSession();){
		Transaction tx = s.beginTransaction();
		pk = (int) s.save(account);
		tx.commit();
		}
		return pk;
	}

}
