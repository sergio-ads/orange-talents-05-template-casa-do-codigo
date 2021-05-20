package br.com.zupacademy.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {

	@Id
	@NotBlank
	private String isbn;
	@NotBlank
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotNull
	@DecimalMax(value = "20")
	private BigDecimal preco;
	@Lob
	private String sumario;
	@NotNull
	@DecimalMin(value = "100")
	private Integer paginas;
	@Future
	private LocalDate dataPublicacao;
	
	@NotNull
	@ManyToMany
	private List<Categoria> categorias;
	@NotNull
	@ManyToMany
	private List<Autor> autores;

	@Deprecated
	public Livro() { }

	public Livro(@NotBlank String isbn, @NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
			@NotNull @DecimalMax("20") BigDecimal preco, String sumario, @NotNull @DecimalMin("100") Integer paginas,
			@Future LocalDate dataPublicacao, @NotNull List<Categoria> categorias, @NotNull List<Autor> autores) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.sumario = sumario;
		this.paginas = paginas;
		this.dataPublicacao = dataPublicacao;		
		this.categorias = categorias;
		this.autores = autores;
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

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public List<Autor> getAutores() {
		return autores;
	}
	
}
