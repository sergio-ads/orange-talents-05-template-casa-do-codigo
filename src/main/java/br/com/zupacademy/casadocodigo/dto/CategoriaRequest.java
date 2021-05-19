package br.com.zupacademy.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.casadocodigo.model.Categoria;

public class CategoriaRequest {
	@NotBlank
	private String nome;
	
	@Deprecated
	public CategoriaRequest() { }

	public CategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		Categoria categoria = new Categoria(nome);
		return categoria;
	}

	public String getNome() {
		return nome;
	}

}
