package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No Pokemon Founded !!")

public class PokemonNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PokemonNotFoundException() {
		super();
	}

	

}
