package br.com.zupacademy.rodrigo.proposta.cartao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.zupacademy.rodrigo.proposta.cartao.biometria.Biometria;


@Entity
public class Cartao {

	@Id
	private String id; 
	private String emitidoEm; 
	private String titular; 
	private BigDecimal limite; 
	private String idProposta; 
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Bloqueio> bloqueios = new ArrayList<Bloqueio>(); 
	@OneToMany(cascade = CascadeType.ALL)
	private List<Aviso> avisos = new ArrayList<Aviso>(); 
	@OneToMany(cascade = CascadeType.ALL)
	private List<Carteira> carteiras = new ArrayList<Carteira>(); 
	@OneToOne(cascade = CascadeType.ALL)
	private Renegociacao renegociacao; 
	@OneToOne(cascade = CascadeType.ALL)
	private Vencimento vencimento; 

	@Enumerated(EnumType.STRING)
	private EstadoCartao estadoCartao; 
	
	@OneToMany
	private List<Biometria> biometrias = new ArrayList<>();
	@Deprecated
	public Cartao() {
	}
	
	public Cartao(String id, String emitidoEm, String titular, BigDecimal limite, String idProposta,
			List<Bloqueio> bloqueios, List<Aviso> avisos, List<Carteira> carteiras, Renegociacao renegociacao,
			Vencimento vencimento) {
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite = limite;
		this.idProposta = idProposta;
		this.bloqueios = bloqueios;
		this.avisos = avisos;
		this.carteiras = carteiras;
		this.renegociacao = renegociacao;
		this.vencimento = vencimento;
		this.estadoCartao = EstadoCartao.NAO_BLOQUEADO; 
	}
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
	public List<Bloqueio> getBloqueios() {
		return bloqueios;
	}
	public List<Aviso> getAvisos() {
		return avisos;
	}
	public List<Carteira> getCarteiras() {
		return carteiras;
	}
	public Renegociacao getRenegociacao() {
		return renegociacao;
	}
	public Vencimento getVencimento() {
		return vencimento;
	}
	public void addBiometria(Biometria biometria){
		this.biometrias.add(biometria);
	}
	public void addAviso(Aviso aviso){
		this.avisos.add(aviso);
	}
	
	public void addBloqueio(Bloqueio bloqueio){
		this.bloqueios.add(bloqueio);
	}
	
	public boolean isBloqueado() {
		if(this.estadoCartao == EstadoCartao.BLOQUEADO) {
			return true; 
		}
		return false; 
	}

	public EstadoCartao getEstadoCartao() {
		return estadoCartao;
	}

	public void setEstadoCartao(EstadoCartao estadoCartao) {
		this.estadoCartao = estadoCartao;
	}
	
}
