package br.com.zupacademy.casadocodigo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@ManyToMany(mappedBy = "categorias")
	private List<Livro> livros;
	
	@Deprecated
	public Categoria() { }

	public List<Livro> getLivros() {
		return livros;
	}

	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
