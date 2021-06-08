package br.com.zupacademy.rodrigo.proposta.validacao;

public class ErrorDTO {

	private String campo;
	private String erro;

	public ErrorDTO(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
}
