package io.egen.movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserCommentNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserCommentNotFoundException(String message){
		super(message);
	}

	public UserCommentNotFoundException(String message,Throwable cause){
		super(message, cause);
	}
}
