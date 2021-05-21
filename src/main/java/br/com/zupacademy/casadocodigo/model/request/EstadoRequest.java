package br.com.zupacademy.casadocodigo.model.request;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.casadocodigo.model.Estado;
import br.com.zupacademy.casadocodigo.model.Pais;
import br.com.zupacademy.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.casadocodigo.validator.UnicoEstadoPorPais;

@UnicoEstadoPorPais
public class EstadoRequest {
	@NotBlank
	private String pais;
	@NotBlank
	private String nome;
	
	public EstadoRequest(@NotBlank String pais, @NotBlank String nome) {
		this.pais = pais;
		this.nome = nome;
	}

	public Estado toModel(PaisRepository paisRepository) {		
		Pais paisObjeto = paisRepository.findByNome(pais).get();
		Estado estado = new Estado(paisObjeto, nome);
		return estado;
	}

	public String getPais() {
		return pais;
	}

	public String getNome() {
		return nome;
	}

}
