package io.egen.movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserRatingNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	
	public UserRatingNotFoundException(String message)
	{
		super(message);
	}
}
