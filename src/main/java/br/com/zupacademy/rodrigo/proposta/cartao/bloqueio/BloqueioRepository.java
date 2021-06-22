package br.com.zupacademy.rodrigo.proposta.cartao.bloqueio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.rodrigo.proposta.cartao.Bloqueio;

@Repository
public interface BloqueioRepository extends JpaRepository<Bloqueio,String>{

}
