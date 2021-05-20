package br.com.zupacademy.casadocodigo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
	
	@Id @GeneratedValue
	private Long id;
	@NotBlank
	private String nome;
	@OneToMany(mappedBy = "pais")
	private List<Estado> estados;
	
	@Deprecated
	public Pais() { }	
	
	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public List<Estado> getEstados() {
		return estados;
	}
	
}
