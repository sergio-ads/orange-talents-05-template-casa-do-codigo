package br.com.zupacademy.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.casadocodigo.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

	Optional<Pais> findByNome(String nome);

}
