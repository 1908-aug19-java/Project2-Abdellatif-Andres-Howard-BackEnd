package com.revature.controllers;

import java.util.List;


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
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Trainer;
import com.revature.services.TrainerService;

@RestController 
@CrossOrigin(maxAge = 3600)
@RequestMapping("/users")
public class TrainerController {

	@Autowired
	private TrainerService trainerService;	
	@GetMapping
	public List<Trainer> getAll(@RequestParam(value="userName",required=false)String userName){
		if(userName!=null) {
			System.out.println(userName);
			return trainerService.findTrainersByuserName(userName);
		}
		return trainerService.findAllTrainers();
	}	
	@GetMapping("/{id}")
	public Trainer getTrainersById(@PathVariable("id")Integer id) {
		return trainerService.findTrainerById(id);

	}
//	@GetMapping("/{userId}/pokemons")
//	public List<Trainer> getAllPokemonByuserId(@PathVariable("userId")Integer userid) {
//		return trainerService.findAllPkemonsByTrainerId(userid);
//	} // move to the pokemon controller
	@PostMapping
	public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer trainer){
		trainerService.addTrainer(trainer);
		return new ResponseEntity<Trainer>(trainer, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public Trainer updateTrainer(@PathVariable("id")Integer id, @RequestBody Trainer t) {
		t.setTrainerId(id);
		return trainerService.updateTrainer(t);		
	}
	
	@DeleteMapping("/{username}")
	public Trainer deleteTrainer(@PathVariable("userName")String username) {
		Trainer trainer = (Trainer) trainerService.findTrainersByuserName(username);
				
		return trainerService.deleteTrainer(trainer);
	}

	 
	
	
	
	
}
