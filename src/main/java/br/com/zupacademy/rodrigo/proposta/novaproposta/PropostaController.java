package br.com.zupacademy.rodrigo.proposta.novaproposta;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.rodrigo.proposta.exception.ApiErroException;
import br.com.zupacademy.rodrigo.proposta.webservice.ConsultaDadosSolicitante;
import br.com.zupacademy.rodrigo.proposta.webservice.dto.PropostaConsultaDadosRequest;
import br.com.zupacademy.rodrigo.proposta.webservice.dto.PropostaConsultaDadosResponse;
import br.com.zupacademy.rodrigo.proposta.webservice.enuns.EstadoProposta;
import feign.FeignException;
import feign.FeignException.FeignClientException;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

	@Autowired
	private PropostaRepository propostaRepository; 
	
	@Autowired
	private ConsultaDadosSolicitante consultaDadosSolicitante; 
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovaPropostaDTO propostaDTO, 
			UriComponentsBuilder uriComponentsBuilder) {
		validarPropostaExistenteComCpfOuCnpj(propostaDTO); 
		Proposta proposta = propostaRepository.save(propostaDTO.toModel()); 
		
		solicitarAnaliseDeProposta(proposta); 
		
		URI uri = uriComponentsBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri(); 
		return ResponseEntity.created(uri).body(proposta); 
	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<PropostaResponse> listarPorId(@PathVariable Integer id){
		Optional<Proposta> proposta =  propostaRepository.findById(id); 
		if(proposta.isPresent()) {
			return ResponseEntity.ok(new PropostaResponse(proposta.get())); 
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
	}

	private void validarPropostaExistenteComCpfOuCnpj(NovaPropostaDTO propostaDTO) {
		Optional<Proposta> proposta = propostaRepository.findByCpfOuCnpj(propostaDTO.getCpfOuCnpj()); 
		if(proposta.isPresent()) {
			throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Não pode haver mais de uma proposta "
					+ "para o mesmo solicitante"); 
		}
	}
	
	private void solicitarAnaliseDeProposta(Proposta proposta) {
		PropostaConsultaDadosResponse resultadoConsulta; 
		try {
			resultadoConsulta = this.consultaDadosSolicitante.
					consultarDadosSolicitante(new PropostaConsultaDadosRequest(proposta)); 
			//Proposta sem restricao
			proposta.setEstadoProposta(EstadoProposta.ELEGIVEL);
			propostaRepository.save(proposta); 
			
		} catch (FeignClientException e) {
			//Proposta com restricao
			proposta.setEstadoProposta(EstadoProposta.NAO_ELEGIVEL);
			propostaRepository.save(proposta); 
		}catch(FeignException e) {
			throw new ApiErroException(HttpStatus.INTERNAL_SERVER_ERROR, "Não foi possível realizar a solicitação de"
					+ " análise para a proposta informada."); 
		}
	}
	
}
