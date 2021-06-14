package br.com.zupacademy.rodrigo.proposta.webservice.dto;

import java.time.LocalDateTime;

public class VencimentoResponse {

	private String id; 
	private String dia; 
	private LocalDateTime dataDeCriacao;
	
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
