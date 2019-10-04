package com.revature.daos;



import java.util.List;

import javax.persistence.criteria.From;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Trainer;

public class TrainerDaoImpl implements TrainerDao {
	
	@Autowired
	private SessionFactory sf;
	


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Trainer> geTrainers() {
		Session s = sf.getCurrentSession();
		List<Trainer> trainers = s.createQuery("from Trainer").list();
		return trainers;
		// TODO Auto-generated method stub
		
	}

}
