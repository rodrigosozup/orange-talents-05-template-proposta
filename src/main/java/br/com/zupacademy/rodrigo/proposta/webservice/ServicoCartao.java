package br.com.zupacademy.rodrigo.proposta.webservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.zupacademy.rodrigo.proposta.webservice.dto.CartaoResponse;
import br.com.zupacademy.rodrigo.proposta.webservice.dto.NotificacaoBloqueioResponse;
import br.com.zupacademy.rodrigo.proposta.webservice.dto.PropostaConsultaDadosRequest;
import br.com.zupacademy.rodrigo.proposta.webservice.dto.SistemaResponsavelRequest;

@FeignClient(name="dadosCartao",  url = "${servico.cartao}")
public interface ServicoCartao {

	@PostMapping(value = "/api/cartoes")
	CartaoResponse consultarCartao(PropostaConsultaDadosRequest request); 
	
	@PostMapping(value = "/api/cartoes/{id}/bloqueios",  consumes = "application/json" )
	NotificacaoBloqueioResponse notificarBloqueioCartao(@PathVariable("id") String id,@RequestBody SistemaResponsavelRequest request); 
}
