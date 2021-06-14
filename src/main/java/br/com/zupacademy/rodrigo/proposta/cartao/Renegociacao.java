package br.com.zupacademy.rodrigo.proposta.cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Renegociacao {

	@Id
	private String id; 
	private int quantidade; 
	private BigDecimal valor; 
	private LocalDateTime dataDeCriacao;
	
	@Deprecated
	public Renegociacao() {
		
	}
		
	public Renegociacao(String id, int quantidade, BigDecimal valor, LocalDateTime dataDeCriacao) {
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.dataDeCriacao = dataDeCriacao;
	}


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
