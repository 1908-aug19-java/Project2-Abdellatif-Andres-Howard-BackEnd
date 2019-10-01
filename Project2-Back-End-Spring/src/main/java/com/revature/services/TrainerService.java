package com.revature.services;

import java.util.List;

import com.revature.models.Trainer;

public interface TrainerService {
	
	public List<Trainer> findAllTrainers();
	public Trainer findTrainerById(Integer id);
	//public Trainer findAllPkemonsByTrainerId(Integer id); moved to pokemon services
	public Trainer addTrainer(Trainer t);
	public Trainer updateTrainer(Trainer t);
	public Trainer deleteTrainer(Trainer t);
	public List<Trainer> findTrainersByuserName(String userName);
	public Boolean validateTrainer(Trainer t);


}
