package br.com.zupacademy.casadocodigo.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.casadocodigo.model.Livro;

public class LivroDto {
	private String isbn;
	private String titulo;
	private String resumo;
	private BigDecimal preco;
	private String sumario;
	private Integer paginas;
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	private List<CategoriaDto> categorias;
	private List<AutorDto> autores;
	
	public LivroDto(Livro livro) {
		this.isbn = livro.getIsbn();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.preco = livro.getPreco();
		this.sumario = livro.getSumario();
		this.paginas = livro.getPaginas();
		this.dataPublicacao = livro.getDataPublicacao();
		this.categorias = new ArrayList<>();
		this.autores = new ArrayList<>();
		this.categorias.addAll(livro.getCategorias().stream().map(CategoriaDto::new).collect(Collectors.toList()));
		this.autores.addAll(livro.getAutores().stream().map(AutorDto::new).collect(Collectors.toList()));
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getSumario() {
		return sumario;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public List<CategoriaDto> getCategorias() {
		return categorias;
	}

	public List<AutorDto> getAutores() {
		return autores;
	}

	public static List<LivroDto> converter(List<Livro> livros) {
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}	

}
