package br.com.zupacademy.rodrigo.proposta.novaproposta;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.rodrigo.proposta.exception.ApiErroException;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

	@Autowired
	private PropostaRepository propostaRepository; 
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovaPropostaDTO propostaDTO, 
			UriComponentsBuilder uriComponentsBuilder) {
		validarPropostaExistenteComCpfOuCnpj(propostaDTO); 
		Proposta proposta = propostaDTO.toModel(); 
		propostaRepository.save(proposta); 
		URI uri = uriComponentsBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri(); 
		return ResponseEntity.created(uri).body(proposta); 
	}
	
	private void validarPropostaExistenteComCpfOuCnpj(NovaPropostaDTO propostaDTO) {
		Optional<Proposta> proposta = propostaRepository.findByCpfOuCnpj(propostaDTO.getCpfOuCnpj()); 
		if(proposta.isPresent()) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Não pode haver mais de uma proposta "
					+ "para o mesmo solicitante"); 
		}
	}
	
}
