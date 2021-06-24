package br.com.zupacademy.rodrigo.proposta.cartao.aviso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.rodrigo.proposta.cartao.Aviso;

@Repository
public interface AvisoRepository extends JpaRepository<Aviso, String>{

}
