package br.com.zupacademy.rodrigo.proposta.biometria;

import javax.validation.constraints.NotBlank;

public class BiometriaRequest {
	
	@NotBlank(message = "Campo Obrigatório")
	private String imgBiometria;


	
	public String getImgBiometria() {
		return imgBiometria;
	}

	public Biometria ToModel() {
		return new Biometria(imgBiometria);
	} 
	
	
}
