package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer , Integer> {
	
public List<Trainer> findTrainersByuserName(String userName);

}
