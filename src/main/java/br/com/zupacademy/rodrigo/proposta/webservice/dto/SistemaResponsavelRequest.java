package br.com.zupacademy.rodrigo.proposta.webservice.dto;

public class SistemaResponsavelRequest {

	private String sistemaResponsavel; 
	
	public SistemaResponsavelRequest(String sistemaResponsavel) {
		this.sistemaResponsavel = sistemaResponsavel; 
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}
}
