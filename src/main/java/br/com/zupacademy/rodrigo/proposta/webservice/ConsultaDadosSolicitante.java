package br.com.zupacademy.rodrigo.proposta.webservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.zupacademy.rodrigo.proposta.webservice.dto.PropostaConsultaDadosRequest;
import br.com.zupacademy.rodrigo.proposta.webservice.dto.PropostaConsultaDadosResponse;

@FeignClient(name ="dadosSolicitante", url = "http://localhost:9999")
public interface ConsultaDadosSolicitante {

	@PostMapping("/api/solicitacao")
	PropostaConsultaDadosResponse consultarDadosSolicitante(@RequestBody PropostaConsultaDadosRequest request); 
}
