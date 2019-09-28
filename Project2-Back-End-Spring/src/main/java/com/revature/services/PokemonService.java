package com.revature.services;

import java.util.List;

import com.revature.models.Pokemon;

public interface PokemonService {

	public List<Pokemon> findAllPokemons();
	public Pokemon findPokemonById(Integer id);
	public Pokemon addPokemon(Pokemon p);
	public Pokemon updatePokemon(Pokemon p);
	public Pokemon deletePokemon(Pokemon p);
    public List<Pokemon> findPokemonsByName(String pokemonName);

	
}
