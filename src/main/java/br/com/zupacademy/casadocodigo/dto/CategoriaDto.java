package br.com.zupacademy.casadocodigo.dto;

import br.com.zupacademy.casadocodigo.model.Categoria;

public class CategoriaDto {
	private String nome;
	
	public CategoriaDto(Categoria categoria) {
		this.nome = categoria.getNome();
	}

	public String getNome() {
		return nome;
	}

}
