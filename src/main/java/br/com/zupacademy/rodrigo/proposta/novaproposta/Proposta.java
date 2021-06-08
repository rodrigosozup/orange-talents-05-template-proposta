package br.com.zupacademy.rodrigo.proposta.novaproposta;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cpfOuCnpj; 
	@NotBlank
	private String email; 
	@NotBlank
	private String nome; 
	@NotBlank
	private String endereco; 
	@NotNull
	@Positive
	private BigDecimal salario;
	
	@Deprecated
	public Proposta() {
		
	}
	
	public Proposta(String cpfOuCnpj, String email, String nome, String endereco, BigDecimal salario) {
		this.cpfOuCnpj = cpfOuCnpj;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
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
	
	private void setId(Integer id) {
		this.id = id; 
	}
	
	
}
