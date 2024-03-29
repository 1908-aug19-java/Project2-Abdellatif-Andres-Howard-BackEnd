package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Pokemon;
import com.revature.repositories.PokemonRepository;
@Service
public class PokemonServiceImpl implements PokemonService{
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Override
	public List<Pokemon> findAllPokemons() {
		
		return pokemonRepository.findAll();
	}
	@Override
	public Pokemon findPokemonByName(String pokemonName) {
		return pokemonRepository.findPokemonByPokemonName(pokemonName);
	}
	@Override
	public List<Pokemon> findPokemonsByUserId(Integer userId)	{
		
		return pokemonRepository.findAllPokemonsByUserId(userId);
	}

	@Override
	public Pokemon addPokemon(Pokemon p) {
		
		return pokemonRepository.save(p);
	}

	@Override
	public Pokemon deletePokemon(Pokemon p){
		if (p!=null)
		{
			pokemonRepository.delete(p);
		}
		return p;
	}
	
	@Override
	public Pokemon updatePokemon(Pokemon p) {
		return pokemonRepository.save(p);
	}

		
}

