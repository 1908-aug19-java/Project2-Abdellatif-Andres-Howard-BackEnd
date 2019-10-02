package com.revature.daos;

import java.util.List;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Pokemon;

@Repository
public class PokemonDaoImpl implements PokemonDao {
	
	@Autowired
	private SessionFactory sf;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Pokemon> getPokemons() {
		Session s = sf.getCurrentSession();
		List<Pokemon> pokemons = s.createQuery("from Pokemon").list();
		return pokemons;
	}

}
