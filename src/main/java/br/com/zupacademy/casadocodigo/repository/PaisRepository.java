package br.com.zupacademy.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.casadocodigo.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

	Pais findByNome(String nome);

}
