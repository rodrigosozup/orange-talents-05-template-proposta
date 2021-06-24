package br.com.zupacademy.rodrigo.proposta.cartao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Aviso {

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id; 
	@Future
	@NotNull
	private LocalDate validoAte;
	@NotBlank
	private String destino;
	@NotBlank
	private String sistemaResponsavel; 
	
	@Deprecated
	public Aviso() {
		
	}
	
	
	public Aviso(LocalDate validoAte, String destino, String sistemaResponsavel) {
		this.validoAte = validoAte;
		this.destino = destino;
		this.sistemaResponsavel = sistemaResponsavel; 
	}


	public String getId() {
		return id;
	}
	public LocalDate getValidoAte() {
		return validoAte;
	}
	public String getDestino() {
		return destino;
	}


	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}
	
}
