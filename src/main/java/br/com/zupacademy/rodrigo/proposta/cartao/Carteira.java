package br.com.zupacademy.rodrigo.proposta.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carteira {

	@Id
	private String id; 
	private String email; 
	private String associadaEm; 
	private String emissor;
	
	@Deprecated
	public Carteira(){
		
	}
	
	
	public Carteira(String id, String email, String associadaEm, String emissor) {
		this.id = id;
		this.email = email;
		this.associadaEm = associadaEm;
		this.emissor = emissor;
	}


	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getAssociadaEm() {
		return associadaEm;
	}
	public String getEmissor() {
		return emissor;
	} 
}
