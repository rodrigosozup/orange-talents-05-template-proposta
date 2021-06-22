package br.com.zupacademy.rodrigo.proposta.cartao.bloqueio;

import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.rodrigo.proposta.cartao.Bloqueio;
import br.com.zupacademy.rodrigo.proposta.cartao.Cartao;
import br.com.zupacademy.rodrigo.proposta.cartao.CartaoRepository;
import br.com.zupacademy.rodrigo.proposta.exception.ApiErroException;

@RestController
@RequestMapping("/cartao")
public class BloqueioController {

	@Autowired
	private BloqueioRepository bloqueioRepository; 
	@Autowired
	private CartaoRepository cartaoRepository; 
	
	@PostMapping("/{id}/bloqueios")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestParam(value = "id") String id, HttpServletRequest request,UriComponentsBuilder uriComponentsBuilder) {
		Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);
		if (cartaoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Cartao cartao = cartaoOptional.get(); 
		verificarBloqueioCartao(cartao); 
		
		String sistemaResponsavel =  request.getLocalAddr() +" - "+ request.getHeader("User-Agent"); 
		Bloqueio bloqueio = new Bloqueio(sistemaResponsavel, true); 
		cartao.addBloqueio(bloqueio);
		bloqueioRepository.save(bloqueio); 
		cartaoRepository.save(cartao); 
		
		URI uri = uriComponentsBuilder.path("/cartao/bloqueios/{id}").buildAndExpand(bloqueio.getId()).toUri();
		return ResponseEntity.created(uri).body(bloqueio); 

	}
	
	private void verificarBloqueioCartao(Cartao cartao){
		if(cartao.isBloqueado()) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Cartão já está bloqueado"); 
		}
	}
}
