package br.com.zupacademy.rodrigo.proposta.exception;

import org.springframework.http.HttpStatus;

public class ApiErroException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private HttpStatus status; 
	private String message; 
	
	public ApiErroException(HttpStatus status, String message) {
		this.status = status; 
		this.message = message; 
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
	
}
