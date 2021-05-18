package br.com.zupacademy.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.casadocodigo.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	

}
