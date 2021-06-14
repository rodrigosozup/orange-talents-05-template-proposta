package br.com.zupacademy.rodrigo.proposta.webservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RenegociacaoResponse {

	private String id; 
	private int quantidade; 
	private BigDecimal valor; 
	private LocalDateTime dataDeCriacao;
	
	
	public String getId() {
		return id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	} 
	
	
}
