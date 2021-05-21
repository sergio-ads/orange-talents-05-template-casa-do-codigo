package br.com.zupacademy.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.casadocodigo.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, String> {

	Optional<Livro> findByIsbn(Long isbn);

	void deleteByIsbn(Long isbn);
	
}
