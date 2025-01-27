package br.com.zupacademy.casadocodigo.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.casadocodigo.model.Autor;
import br.com.zupacademy.casadocodigo.validator.UniqueValue;

public class AutorRequest {
	@NotBlank
	private String nome;
	@Email
	@NotBlank
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;	
	
	public AutorRequest(@NotBlank String nome, @Email @NotBlank String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		Autor autor = new Autor(nome, email, descricao);
		return autor;
	}

	public String getEmail() {
		return email;
	}

}
