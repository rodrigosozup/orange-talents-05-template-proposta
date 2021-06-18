package br.com.zupacademy.rodrigo.proposta.biometria;

import java.net.URI;
import java.util.Base64;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.rodrigo.proposta.cartao.Cartao;
import br.com.zupacademy.rodrigo.proposta.cartao.CartaoRepository;
import br.com.zupacademy.rodrigo.proposta.exception.ApiErroException;

@RestController
@RequestMapping("/cartao")
public class BiometriaController {

	@Autowired
	private BiometriaRepository biometriaRepository;
	@Autowired
	private CartaoRepository cartaoRepository;

	@PostMapping("/{id}/biometrias")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid BiometriaRequest biometriaRequest,
			@RequestParam(value = "id") String id, UriComponentsBuilder uriComponentsBuilder) {
		Optional<Cartao> cartao = cartaoRepository.findById(id);
		if (cartao.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		verificarBase64(biometriaRequest);

		Biometria biometria = biometriaRequest.ToModel();
		cartao.get().addBiometria(biometria);
		biometriaRepository.save(biometria);
		cartaoRepository.save(cartao.get());

		URI uri = uriComponentsBuilder.path("/cartao/biometrias/{id}").buildAndExpand(biometria.getId()).toUri();
		return ResponseEntity.created(uri).body(biometria);

	}
	
	@GetMapping("/biometrias/{id}")
	public ResponseEntity<BiometriaResponse> listarPorId(@PathVariable String id) {
		Optional<Biometria> biometria = biometriaRepository.findById(id); 
		if(biometria.isPresent()) {
			return ResponseEntity.ok(new BiometriaResponse(biometria.get())); 
		}
		return ResponseEntity.notFound().build(); 
	}

	private void verificarBase64(BiometriaRequest biometriaRequest) {

		try {
			String imgBiometriaRequest = biometriaRequest.getImgBiometria();
			byte[] decode = Base64.getDecoder().decode(imgBiometriaRequest.getBytes());
		} catch (IllegalArgumentException e) {
		    throw new ApiErroException(HttpStatus.BAD_REQUEST, "Biometria deve estar em Base64");
		}
	}
}
