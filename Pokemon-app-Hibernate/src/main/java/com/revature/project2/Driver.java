package com.revature.project2;

import org.hibernate.Session;

import com.revature.project2.util.HibernateUtil;


public class Driver {
	public static void main(String[] args) {
		
		Session s = HibernateUtil.getSession();

		
		
		
		HibernateUtil.closeSessionFactory();
	}
}
