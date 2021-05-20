package br.com.zupacademy.casadocodigo.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.casadocodigo.model.Categoria;

public class CategoriaDto {
	private String nome;
	
	public CategoriaDto(Categoria categoria) {
		this.nome = categoria.getNome();
	}

	public String getNome() {
		return nome;
	}

	public static List<CategoriaDto> converter(List<Categoria> categorias) {
		return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
	}

}
