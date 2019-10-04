package com.revature.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.PokemonNotFoundException;
import com.revature.models.Pokemon;
import com.revature.services.PokemonService;



@RestController 
@CrossOrigin()

@RequestMapping("/pokemons")

public class PokemonController {
	private static Logger log = Logger.getRootLogger();
	@Autowired
	private PokemonService pokemonService;
	
	@GetMapping
	public List<Pokemon> getAll()
	{	
		return pokemonService.findAllPokemons();
	}	
	@GetMapping("/{userId}")
	public List<Pokemon> getAllPokemonsByUserId(@PathVariable("userId")Integer id) {
		List<Pokemon> pokelist= pokemonService.findPokemonsByUserId(id);
		if (pokelist==null) {
			throw new PokemonNotFoundException();
		}
		return pokelist;
	}
	@GetMapping("/pokemons")
	@ResponseBody
	public Pokemon getpokemonsByName(@RequestParam(name="pokemonName",required=false) String name){

		if(name==null) {
			throw new PokemonNotFoundException();

		}
		return pokemonService.findPokemonByName(name);		
	}
	@PostMapping
	public ResponseEntity<Pokemon> addPokemon(@RequestBody Pokemon p){
		if (p==null) {
			log.info("Form cannot be null");				
		    return new ResponseEntity<Pokemon>(HttpStatus.BAD_REQUEST);
		}
		
		pokemonService.addPokemon(p);
		return new ResponseEntity<Pokemon>(p, HttpStatus.CREATED);
	}
	@PutMapping("/{pokemonName}")
	public Pokemon updatePokemon(@PathVariable("pokemonName")String name, @RequestBody Pokemon p) {
		p.setPokemonNickName(name);
		
		return pokemonService.updatePokemon(p);
		
	}
	@DeleteMapping("/{pokemonName}")
	public Pokemon deletePokemon(@PathVariable("pokemonName")String pokeName) {
		Pokemon p =  pokemonService.findPokemonByName(pokeName);
		if (p==null) {
			throw new PokemonNotFoundException();
		}
		return pokemonService.deletePokemon(p);
	}
}
