package br.com.zupacademy.casadocodigo.dto;

import br.com.zupacademy.casadocodigo.model.Autor;

public class AutorDto {
	private String nome;
	private String email;
	private String descricao;
	
	public AutorDto(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
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
	
}
