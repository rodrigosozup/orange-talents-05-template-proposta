package br.com.zupacademy.rodrigo.proposta.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidacaoErrorHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorDTO> validacao(MethodArgumentNotValidException ex){
		
		List<ErrorDTO> errosValidacao = new ArrayList<ErrorDTO>(); 
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors(); 
		
		fieldErrors.forEach(e ->{
			errosValidacao.add(new ErrorDTO(e.getField(), e.getDefaultMessage())); 
		});
		
		return errosValidacao;
	}
}
