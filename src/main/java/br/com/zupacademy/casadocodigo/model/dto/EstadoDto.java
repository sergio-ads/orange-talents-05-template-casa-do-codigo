package br.com.zupacademy.casadocodigo.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.casadocodigo.model.Estado;

public class EstadoDto {
	private String nome;
	private PaisDto pais;
	
	public EstadoDto(Estado estado) {
		this.nome = estado.getNome();
		this.pais = new PaisDto(estado.getPais());
	}

	public String getNome() {
		return nome;
	}

	public PaisDto getPais() {
		return pais;
	}

	public static List<EstadoDto> converter(List<Estado> estados) {
		return estados.stream().map(EstadoDto::new).collect(Collectors.toList());
	}

}
