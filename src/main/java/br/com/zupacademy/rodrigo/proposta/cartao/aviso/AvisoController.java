package br.com.zupacademy.rodrigo.proposta.cartao.aviso;

import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.rodrigo.proposta.cartao.Aviso;
import br.com.zupacademy.rodrigo.proposta.cartao.Cartao;
import br.com.zupacademy.rodrigo.proposta.cartao.CartaoRepository;

@RestController
@RequestMapping("/cartao")
public class AvisoController {

	@Autowired
	private CartaoRepository cartaoRepository; 
	@Autowired
	private AvisoRepository avisoRepository; 
	
	@PostMapping("/{id}/avisos")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestParam(value = "id") String id,@RequestBody @Valid AvisoRequest avisoRequest,  HttpServletRequest httpRequest,
			UriComponentsBuilder uriComponentsBuilder) {
		Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);
		if (cartaoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Cartao cartao = cartaoOptional.get();  
		Aviso aviso = avisoRequest.ToModel(httpRequest); 
		cartao.addAviso(aviso);
		avisoRepository.save(aviso); 
		cartaoRepository.save(cartao); 
		
		URI uri = uriComponentsBuilder.path("/cartao/avisos/{id}").buildAndExpand(aviso.getId()).toUri();
		return ResponseEntity.created(uri).body(aviso);

	}
}
