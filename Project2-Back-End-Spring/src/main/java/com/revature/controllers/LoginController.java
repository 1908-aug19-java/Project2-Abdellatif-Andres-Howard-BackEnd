package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Trainer;
import com.revature.services.TrainerService;

@RestController 
@CrossOrigin(maxAge = 3600)
@RequestMapping("/login")
public class LoginController 
{
	@Autowired
	private TrainerService trainerService;

	@PostMapping
	public ResponseEntity <Trainer> getUserLogin(@RequestBody Trainer trainer)
	{
		System.out.println("login info "+trainerService.validateTrainer(trainer));
		Boolean result =trainerService.validateTrainer(trainer);
		System.out.println("login: "+result);
		if (trainer!=null) {
			if (result) 
			{
				System.out.println(trainer);
				//trainer.getTrainerId();
			    return new ResponseEntity<Trainer>(trainer,HttpStatus.OK);
				//Trainer t=trainerService.findTrainerById(id);

			}
			else 
			{
				System.out.println("Wrong Credinetial");				
			    return new ResponseEntity<Trainer>(HttpStatus.NOT_FOUND);
			}
		}
		else 
		{
			System.out.println(" Empty Crediential");				
			return null;
		}
	}
}
