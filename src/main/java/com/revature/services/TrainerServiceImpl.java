package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Trainer;
import com.revature.repositories.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService {
	
	@Autowired
	private TrainerRepository trainerRepository;
	
	@Override
	public List<Trainer> findAllTrainers() {
		return trainerRepository.findAll();
	}
	@Override
	public Trainer findTrainerById(Integer id) {
		return trainerRepository.getOne(id);
	}

	@Override
	public Trainer addTrainer(Trainer t) {
		return trainerRepository.save(t);
	}

	@Override
	public Trainer updateTrainer(Trainer t) {
		return trainerRepository.save(t);
	}

	@Override
	public Trainer deleteTrainer(Trainer t) {
		if(t!=null)
		{
		trainerRepository.delete(t);
		}
		return t;
	}
	@Override
	public Trainer findTrainerByuserName(String userName) {
		return trainerRepository.findTrainerByuserName(userName);
	}
	@Override
	public Boolean  validateTrainer(Trainer t) {
		return trainerRepository.findTrainerByuserNameAndPassword(t.getUserName(),t.getPassword())!=null;
	}
}
