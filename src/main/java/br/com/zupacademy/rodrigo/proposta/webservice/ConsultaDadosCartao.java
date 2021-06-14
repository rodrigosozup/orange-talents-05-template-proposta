package br.com.zupacademy.rodrigo.proposta.webservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.zupacademy.rodrigo.proposta.webservice.dto.CartaoResponse;
import br.com.zupacademy.rodrigo.proposta.webservice.dto.PropostaConsultaDadosRequest;

@FeignClient(name="dadosCartao",  url = "http://localhost:8888")
public interface ConsultaDadosCartao {

	@PostMapping(value = "/api/cartoes")
	CartaoResponse consultarCartao(PropostaConsultaDadosRequest request); 
}
