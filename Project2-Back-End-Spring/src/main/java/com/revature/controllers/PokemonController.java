package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Pokemon;
//import com.revature.services.PokemonService;
import com.revature.services.PokemonService;



@RestController // or add response body to each mapping
@RequestMapping("/pokemons")

public class PokemonController {
	@Autowired
	private PokemonService pokemonService;
	
	@GetMapping
	public List<Pokemon> getAll(@RequestParam(value="pokemonName",required=false)String name){
		if(name!=null) {
			return  pokemonService.findPokemonsByName(name);
		}
		return pokemonService.findAllPokemons();
	}	
	@GetMapping("/{id}")
	public Pokemon getPokemonById(@PathVariable("id")Integer id) {
		return pokemonService.findPokemonById(id);
	}
	
	@PostMapping
	public ResponseEntity<Pokemon> addPokemon(@RequestBody Pokemon p){
		pokemonService.addPokemon(p);
		return new ResponseEntity<Pokemon>(p, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Pokemon updatePokemon(@PathVariable("pokemonNickName")String nickName, @RequestBody Pokemon p) {
		p.setPokemonNickName(nickName);
		return pokemonService.updatePokemon(p);
		
	}
	
	@DeleteMapping("/{id}")
	public Pokemon deletePokemon(@PathVariable("pokemonName")String name) {
		return pokemonService.deletePokemon(new Pokemon(name));
	}
	
}
