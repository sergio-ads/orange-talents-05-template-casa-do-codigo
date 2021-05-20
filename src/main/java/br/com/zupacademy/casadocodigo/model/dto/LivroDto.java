package br.com.zupacademy.casadocodigo.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.casadocodigo.model.Livro;

public class LivroDto {
	private String isbn;
	private String titulo;
	
	public LivroDto(Livro livro) {
		this.isbn = livro.getIsbn();
		this.titulo = livro.getTitulo();
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<LivroDto> converter(List<Livro> livros) {
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}	

}
