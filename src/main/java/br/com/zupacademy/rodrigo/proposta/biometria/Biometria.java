package br.com.zupacademy.rodrigo.proposta.biometria;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Biometria {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotBlank
    private String imgBiometria;
    private LocalDateTime dataAssociacaoCartao = LocalDateTime.now() ;
	
    @Deprecated
    public Biometria() {
    }
    
    public Biometria(@NotBlank String imgBiometria) {
		this.imgBiometria = imgBiometria;
	}

	public String getId() {
		return id;
	}

	public String getImgBiometria() {
		return imgBiometria;
	}

	public LocalDateTime getDataAssociacaoCartao() {
		return dataAssociacaoCartao;
	}  
}
