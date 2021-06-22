package br.com.zupacademy.rodrigo.proposta.webservice.dto;

import br.com.zupacademy.rodrigo.proposta.cartao.Bloqueio;

public class BloqueioResponse {

	private String id; 
	private String bloqueadoEm;
    private String sistemaResponsavel; 
    private boolean ativo;
    
    
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
	
	public Bloqueio toModel() {
		return new Bloqueio(sistemaResponsavel, ativo); 
	}
    
}
