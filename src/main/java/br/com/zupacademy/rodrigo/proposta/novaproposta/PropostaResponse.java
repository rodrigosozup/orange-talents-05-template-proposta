package br.com.zupacademy.rodrigo.proposta.novaproposta;

import java.math.BigDecimal;

import br.com.zupacademy.rodrigo.proposta.webservice.enuns.EstadoProposta;

public class PropostaResponse {
	
	private Integer id;
	private String cpfOuCnpj; 
	private String email; 
	private String nome; 
	private String endereco; 
	private BigDecimal salario;
	private EstadoProposta estadoProposta; 
	
	public PropostaResponse(Proposta proposta) {
		this.id = proposta.getId(); 
		this.cpfOuCnpj = proposta.getCpfOuCnpj(); 
		this.email = proposta.getEmail(); 
		this.nome = proposta.getNome(); 
		this.endereco = proposta.getEndereco(); 
		this.salario = proposta.getSalario(); 
		this.estadoProposta = proposta.getEstadoProposta(); 
	}

	public Integer getId() {
		return id;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public EstadoProposta getEstadoProposta() {
		return estadoProposta;
	}
	
	
}
