package br.com.zupacademy.casadocodigo.model.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Lob;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.casadocodigo.model.Autor;
import br.com.zupacademy.casadocodigo.model.Categoria;
import br.com.zupacademy.casadocodigo.model.Livro;
import br.com.zupacademy.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.casadocodigo.validator.UniqueValue;

public class LivroRequest {
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
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
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	private List<String> categorias;
	@NotNull
	private List<String> autores;

	public LivroRequest(@NotBlank String isbn, @NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
			@NotNull @DecimalMax("20") BigDecimal preco, String sumario, @NotNull @DecimalMin("100") Integer paginas,
			@NotNull List<String> categorias, @NotNull List<String> autores) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.sumario = sumario;
		this.paginas = paginas;
		this.categorias = categorias;
		this.autores = autores;
	}

	public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		List<Categoria> categoriasObjeto = new ArrayList<>();
		List<Autor> autoresObjeto = new ArrayList<>(); 
		for (String c : categorias) {
			Categoria categoria = categoriaRepository.findByNome(c).get();
			categoriasObjeto.add(categoria);
		}
		for (String a : autores) {
			Autor autor = autorRepository.findByEmail(a).get();
			autoresObjeto.add(autor);
		}
		Livro livro = new Livro(isbn, titulo, resumo, preco, sumario, paginas, dataPublicacao, categoriasObjeto, autoresObjeto);
		return livro;
	}
	
	/*
	 *  Setter criado pois o jackson não soube desserializar sem esse método. 
	 *  Removido o dataPublicação do construtor também.
	 */
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}	

}
