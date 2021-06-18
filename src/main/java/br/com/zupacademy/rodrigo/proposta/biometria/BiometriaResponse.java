package br.com.zupacademy.rodrigo.proposta.biometria;

import java.time.LocalDateTime;

public class BiometriaResponse {

	private String id;
    private String imgBiometria;
    private LocalDateTime dataAssociacaoCartao;
	
    public BiometriaResponse(Biometria biometria) {
    	this.id= biometria.getId(); 
    	this.imgBiometria = biometria.getImgBiometria(); 
    	this.dataAssociacaoCartao = biometria.getDataAssociacaoCartao(); 
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
