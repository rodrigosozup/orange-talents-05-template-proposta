package br.com.zupacademy.rodrigo.proposta.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bloqueio {

	@Id
	private String id; 
	private String bloqueadoEm;
    private String sistemaResponsavel; 
    private boolean ativo;
    
    @Deprecated
    public Bloqueio() {
    }
    
	public Bloqueio(String id, String bloqueadoEm, String sistemaResponsavel, boolean ativo) {
		this.id = id;
		this.bloqueadoEm = bloqueadoEm;
		this.sistemaResponsavel = sistemaResponsavel;
		this.ativo = ativo;
	}
	
	public String getId() {
		return id;
	}
	public String getBloqueadoEm() {
		return bloqueadoEm;
	}
	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}
	public boolean isAtivo() {
		return ativo;
	} 
}
