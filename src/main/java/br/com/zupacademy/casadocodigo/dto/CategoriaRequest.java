package br.com.zupacademy.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.casadocodigo.model.Categoria;
import br.com.zupacademy.casadocodigo.validator.UniqueValue;

public class CategoriaRequest {
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
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
