package com.revature.services;

import java.util.List;

import com.revature.models.Pokemon;
import com.revature.models.Trainer;

public interface PokemonService {

	public List<Pokemon> findAllPokemons();
	public Pokemon findPokemonById(Pokemon id);
	public Pokemon addPokemon(Pokemon p);
	//public Pokemon updateTrainer(Pokemon p);
	public Pokemon deletePokemon(Pokemon p);
	//public List<Pokemon> findTrainersByuserName(String userName);
	
}
