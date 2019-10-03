package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No Trainer Account with username given Exist")

public class TrainerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TrainerNotFoundException() {
		super();
	}

	
}
