package br.com.zupacademy.casadocodigo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Autor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@ManyToMany(mappedBy = "autores")
	private List<Livro> livros;
	
	@Deprecated
	public Autor() {
	}

	public Autor(@NotBlank String nome, @Email @NotBlank String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public List<Livro> getLivros() {
		return livros;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getDescricao() {
		return descricao;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
}
