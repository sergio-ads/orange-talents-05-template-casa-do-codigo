package br.com.zupacademy.casadocodigo.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.casadocodigo.model.Livro;

public class LivroSimplesDto {
	private String isbn;
	private String titulo;
	
	public LivroSimplesDto(Livro livro) {
		this.isbn = livro.getIsbn();
		this.titulo = livro.getTitulo();
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<LivroSimplesDto> converter(List<Livro> livros) {
		return livros.stream().map(LivroSimplesDto::new).collect(Collectors.toList());
	}	

}
