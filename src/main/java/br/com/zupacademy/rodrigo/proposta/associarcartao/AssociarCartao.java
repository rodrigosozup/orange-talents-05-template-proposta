package br.com.zupacademy.rodrigo.proposta.associarcartao;

import br.com.zupacademy.rodrigo.proposta.cartao.Cartao;
import br.com.zupacademy.rodrigo.proposta.cartao.CartaoRepository;
import br.com.zupacademy.rodrigo.proposta.exception.ApiErroException;
import br.com.zupacademy.rodrigo.proposta.novaproposta.Proposta;
import br.com.zupacademy.rodrigo.proposta.novaproposta.PropostaRepository;
import br.com.zupacademy.rodrigo.proposta.webservice.ServicoCartao;
import br.com.zupacademy.rodrigo.proposta.webservice.dto.CartaoResponse;
import br.com.zupacademy.rodrigo.proposta.webservice.dto.PropostaConsultaDadosRequest;
import br.com.zupacademy.rodrigo.proposta.webservice.enuns.EstadoProposta;
import feign.FeignException;
import feign.FeignException.FeignClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssociarCartao {

	@Autowired
	private PropostaRepository propostaRepository; 
	@Autowired
	private ServicoCartao  consultaDadosCartao; 
	@Autowired
	private CartaoRepository cartaoRepository; 
	
	@Scheduled(fixedDelay = 1000)
	public void associarCartao() {
		List<Proposta> propostas = propostaRepository.findByIdCartaoIsNullAndEstadoProposta(EstadoProposta.ELEGIVEL);
		
		propostas.forEach(e ->{
			try {
				CartaoResponse cartaoResponse = consultaDadosCartao.consultarCartao(new PropostaConsultaDadosRequest(e)); 
				e.setIdCartao(cartaoResponse.getId()); 
				propostaRepository.save(e); 
				Cartao cartao = cartaoResponse.ToModel(); 
				cartaoRepository.save(cartao);
			} catch (FeignClientException ex) {
				throw new ApiErroException(HttpStatus.BAD_REQUEST, "Não foi possível associar cartão a proposta"); 
			}catch(FeignException ex) {
				throw new ApiErroException(HttpStatus.INTERNAL_SERVER_ERROR, "Não foi possível consultar dados para o cartão."); 
			}
			
		});
		
	}
}
