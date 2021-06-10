package br.com.zupacademy.rodrigo.proposta.webservice.dto;

import br.com.zupacademy.rodrigo.proposta.novaproposta.Proposta;

public class PropostaConsultaDadosRequest {

	private String documento; 
	private String nome; 
	private String idProposta; 
	
	
	public PropostaConsultaDadosRequest(Proposta proposta) {
		this.documento = proposta.getCpfOuCnpj(); 
		this.nome = proposta.getNome(); 
		this.idProposta = proposta.getId().toString(); 
	}


	public String getDocumento() {
		return documento;
	}


	public String getNome() {
		return nome;
	}


	public String getIdProposta() {
		return idProposta;
	}
	
}
