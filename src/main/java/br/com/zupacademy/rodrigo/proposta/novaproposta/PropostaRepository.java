package br.com.zupacademy.rodrigo.proposta.novaproposta;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.rodrigo.proposta.webservice.enuns.EstadoProposta;

public interface PropostaRepository extends JpaRepository<Proposta, Integer>{

	Optional<Proposta> findByCpfOuCnpj(String cpfOuCnpj);

	List<Proposta> findByIdCartaoIsNullAndEstadoProposta(EstadoProposta estadoProposta); 
}
