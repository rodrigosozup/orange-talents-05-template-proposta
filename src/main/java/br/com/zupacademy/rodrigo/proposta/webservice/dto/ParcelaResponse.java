package br.com.zupacademy.rodrigo.proposta.webservice.dto;

import java.math.BigDecimal;

public class ParcelaResponse {

	private String id;
	private int quantidade;
	private BigDecimal valor;
	
	public String getId() {
		return id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}

	
}
