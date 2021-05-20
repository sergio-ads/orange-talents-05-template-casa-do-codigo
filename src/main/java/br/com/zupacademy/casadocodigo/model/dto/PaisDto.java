package br.com.zupacademy.casadocodigo.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.casadocodigo.model.Pais;

public class PaisDto {
	private String nome;

	public PaisDto(Pais pais) {
		this.nome = pais.getNome();
	}

	public String getNome() {
		return nome;
	}

	public static List<PaisDto> converter(List<Pais> paises) {
		return paises.stream().map(PaisDto::new).collect(Collectors.toList());
	}	
}
