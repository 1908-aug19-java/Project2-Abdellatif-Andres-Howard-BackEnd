package com.revature.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon , Integer> 
{
	public List<Pokemon> findByPokemonName(String pokemonName);

}
