package br.com.zupacademy.rodrigo.proposta.novaproposta;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.rodrigo.proposta.validacao.CPFOrCNPJ;

public class NovaPropostaDTO {

	@CPFOrCNPJ
	private String cpfOuCnpj; 
	@NotBlank(message = "Preenchimento obrigatório")
	private String email; 
	@NotBlank(message = "Preenchimento obrigatório")
	private String nome; 
	@NotBlank(message = "Preenchimento obrigatório")
	private String endereco; 
	@NotNull
	@Positive
	private BigDecimal salario; 
	
	

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

	public Proposta toModel() {
		return new Proposta(cpfOuCnpj, email, nome, endereco, salario);
	}

}
