package br.com.zupacademy.rodrigo.proposta.cartao.aviso;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.rodrigo.proposta.cartao.Aviso;

public class AvisoRequest {

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy" , shape = Shape.STRING)
	@NotNull
	private LocalDate validoAte;
	@NotBlank(message = "Preenchimento Obrigatório")
	private String destino;
	
	public LocalDate getValidoAte() {
		return validoAte;
	}
	public String getDestino() {
		return destino;
	}
	public Aviso ToModel(HttpServletRequest httpRequest) {
		return new Aviso(validoAte, destino, httpRequest.getLocalAddr() + " - " + 
							httpRequest.getHeader("User-Agent"));
	}
	
}
