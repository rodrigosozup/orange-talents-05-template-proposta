package br.com.zupacademy.rodrigo.proposta.cartao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vencimento {

	@Id
	private String id; 
	private String dia; 
	private LocalDateTime dataDeCriacao;
	
	@Deprecated
	public Vencimento() {
	}
	
	public Vencimento(String id, String dia, LocalDateTime dataDeCriacao) {
		this.id = id;
		this.dia = dia;
		this.dataDeCriacao = dataDeCriacao;
	}
	
	public String getId() {
		return id;
	}
	public String getDia() {
		return dia;
	}
	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	} 
}
