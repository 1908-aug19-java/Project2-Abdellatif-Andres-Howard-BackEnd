package com.revature.controllers;

import org.apache.log4j.Logger;
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
@CrossOrigin()
@RequestMapping("/login")
public class LoginController 
{	private static Logger log = Logger.getRootLogger();

	@Autowired
	private TrainerService trainerService;

	@PostMapping
	public ResponseEntity <Trainer> getUserLogin(@RequestBody Trainer trainer)
	{
		log.info("login info "+trainerService.validateTrainer(trainer));
		Boolean result =trainerService.validateTrainer(trainer);
		log.info("login: "+result);
		if (trainer!=null) {
			if (Boolean.TRUE.equals(result)) 
			{
				log.info(trainer);
				
			    return new ResponseEntity<Trainer>(trainer,HttpStatus.OK);
			}
			else 
			{
				log.info("Wrong Credinetial");				
			    return new ResponseEntity<Trainer>(HttpStatus.NOT_FOUND);
			}
		}
		else 
		{
			log.info(" Empty Crediential");				
			return null;
		}
	}
}
