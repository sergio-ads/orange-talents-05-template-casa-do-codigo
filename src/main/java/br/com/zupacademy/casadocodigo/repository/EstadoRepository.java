package br.com.zupacademy.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.casadocodigo.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

	Optional<Estado> findByNome(String nome);

	Optional<Estado> findByNomeAndPais_Nome(String estado, String pais);

}
