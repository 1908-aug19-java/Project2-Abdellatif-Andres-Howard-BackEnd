package com.revature.services;

import java.util.List;

import com.revature.models.Pokemon;

public interface PokemonService {

	public List<Pokemon> findAllPokemons();
	public List<Pokemon> findPokemonsByUserId(Integer userId);

    public Pokemon findPokemonByName(String pokemonName);

	public Pokemon addPokemon(Pokemon p);
	public Pokemon updatePokemon(Pokemon p);
	public Pokemon deletePokemon(Pokemon p);

	
}
