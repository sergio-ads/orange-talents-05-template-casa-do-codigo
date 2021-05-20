package br.com.zupacademy.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

	@Id @GeneratedValue
	private Long id;
	@NotNull
	@ManyToOne
	private Pais pais;
	@NotBlank
	private String nome;
	
	@Deprecated
	public Estado() { }
	
	public Estado(@NotNull Pais pais, @NotBlank String nome) {
		this.pais = pais;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public Pais getPais() {
		return pais;
	}

	public String getNome() {
		return nome;
	}
}
