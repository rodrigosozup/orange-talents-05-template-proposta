package br.com.zupacademy.rodrigo.proposta.cartao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Bloqueio {

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id; 
	private LocalDateTime bloqueadoEm = LocalDateTime.now();
    private String sistemaResponsavel; 
    private boolean ativo;
    
    @Deprecated
    public Bloqueio() {
    }
    
	public Bloqueio(String sistemaResponsavel, boolean ativo) {
		this.sistemaResponsavel = sistemaResponsavel;
		this.ativo = ativo;
	}
	
	public String getId() {
		return id;
	}
	public LocalDateTime getBloqueadoEm() {
		return bloqueadoEm;
	}
	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}
	public boolean isAtivo() {
		return ativo;
	} 
}
