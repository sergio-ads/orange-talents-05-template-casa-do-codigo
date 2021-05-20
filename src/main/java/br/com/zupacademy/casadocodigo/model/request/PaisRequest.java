package br.com.zupacademy.casadocodigo.model.request;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.casadocodigo.model.Pais;
import br.com.zupacademy.casadocodigo.validator.UniqueValue;

public class PaisRequest {
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	@NotBlank
	private String nome;

	@Deprecated
	public PaisRequest() {	}
	
	public PaisRequest(@NotBlank String nome) {
		this.nome = nome;
	}
	
	public Pais toModel() {
		Pais pais = new Pais(nome);
		return pais;		
	}

	public String getNome() {
		return nome;
	}	

}
