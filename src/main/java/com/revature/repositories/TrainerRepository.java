package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer , Integer> 
{
	public List<Trainer> findTrainersByuserName(String userName);//for forgetting username
	public Trainer findTrainerByuserName(String userName);//for delet
	public Trainer findTrainerByuserNameAndPassword(String userName, String password);
	public List<Trainer> findAllPokemonByTrainerId(Integer id);

		
	
}
