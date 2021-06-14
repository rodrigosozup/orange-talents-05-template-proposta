package br.com.zupacademy.rodrigo.proposta.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aviso {

	@Id
	private String id; 
	private String validoAte;
	private String destino;
	
	@Deprecated
	public Aviso() {
		
	}
	
	
	public Aviso(String id, String validoAte, String destino) {
		this.id = id;
		this.validoAte = validoAte;
		this.destino = destino;
	}


	public String getId() {
		return id;
	}
	public String getValidoAte() {
		return validoAte;
	}
	public String getDestino() {
		return destino;
	}
}
