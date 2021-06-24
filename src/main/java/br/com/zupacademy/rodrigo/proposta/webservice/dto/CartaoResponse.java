package br.com.zupacademy.rodrigo.proposta.webservice.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.rodrigo.proposta.cartao.Aviso;
import br.com.zupacademy.rodrigo.proposta.cartao.Bloqueio;
import br.com.zupacademy.rodrigo.proposta.cartao.Cartao;
import br.com.zupacademy.rodrigo.proposta.cartao.Carteira;
import br.com.zupacademy.rodrigo.proposta.cartao.Renegociacao;
import br.com.zupacademy.rodrigo.proposta.cartao.Vencimento;

public class CartaoResponse {

	private String id; 
	private String emitidoEm; 
	private String titular; 
	private BigDecimal limite; 
	private String idProposta; 
	
	private List<BloqueioResponse> bloqueios = new ArrayList<BloqueioResponse>(); 
	private List<AvisoResponse> avisos = new ArrayList<AvisoResponse>(); 
	private List<CarteiraResponse> carteiras = new ArrayList<CarteiraResponse>(); 
	private RenegociacaoResponse renegociacao; 
	private VencimentoResponse vencimento; 
	
	
	public String getId() {
		return id;
	}
	public String getEmitidoEm() {
		return emitidoEm;
	}
	public String getTitular() {
		return titular;
	}
	public BigDecimal getLimite() {
		return limite;
	}
	public String getIdProposta() {
		return idProposta;
	}
	public List<BloqueioResponse> getBloqueios() {
		return bloqueios;
	}
	public List<AvisoResponse> getAvisos() {
		return avisos;
	}
	public List<CarteiraResponse> getCarteiras() {
		return carteiras;
	}
	public RenegociacaoResponse getRenegociacao() {
		return renegociacao;
	}
	public VencimentoResponse getVencimento() {
		return vencimento;
	}
	public Cartao ToModel() {
		return new Cartao(id, emitidoEm, titular, limite, idProposta, toModelListBloqueio(), toModelListAviso(), toModelListCarteira(), toModelRenegociacao(), toModelVencimento());
	} 
	
	private List<Bloqueio> toModelListBloqueio() {
		List<Bloqueio> list = new ArrayList<Bloqueio>(); 
		this.bloqueios.forEach(e ->{
			list.add(e.toModel()); 
		});
		return list; 
	}
	
	private List<Aviso> toModelListAviso() {
		/*Modificação necessaria,  a mdevidoudança no construtor da classe Aviso. 
		 * O objeto Aviso Response ainda não foi utilizado no sistema*/ 
		return avisos.stream()
				.map(e -> new Aviso() ).collect(Collectors.toList()); 
	}
	
	private List<Carteira> toModelListCarteira() {
		return carteiras.stream()
				.map(e -> new Carteira(e.getId(), e.getEmail(), e.getAssociadaEm(), e.getEmissor())).collect(Collectors.toList()); 
	}
	
	private Renegociacao toModelRenegociacao() {
		if(this.renegociacao != null) {
			return new Renegociacao(this.renegociacao.getId(),this.renegociacao.getQuantidade() , this.renegociacao.getValor(), this.renegociacao.getDataDeCriacao()); 
		}
		return null; 
	}
	
	private Vencimento toModelVencimento() {
		return new Vencimento(this.vencimento.getId(), this.vencimento.getDia(), this.vencimento.getDataDeCriacao()); 
	}
}

