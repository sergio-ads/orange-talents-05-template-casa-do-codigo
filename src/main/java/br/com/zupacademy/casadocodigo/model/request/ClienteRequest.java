package br.com.zupacademy.casadocodigo.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.casadocodigo.model.Cliente;
import br.com.zupacademy.casadocodigo.model.Estado;
import br.com.zupacademy.casadocodigo.model.Pais;
import br.com.zupacademy.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.casadocodigo.validator.CpfOrCnpj;
import br.com.zupacademy.casadocodigo.validator.UniqueValue;
import br.com.zupacademy.casadocodigo.validator.ValidarEstadoPorPais;

@ValidarEstadoPorPais
public class ClienteRequest {
	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@CpfOrCnpj
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	@NotBlank
	private String pais;
	private String estado;

	public ClienteRequest(@NotBlank @Email String email,
			@NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento, @NotBlank String endereco,
			@NotBlank String complemento, @NotBlank String cidade, @NotBlank String telefone, @NotBlank String cep,
			@NotBlank String pais, String estado) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.telefone = telefone;
		this.cep = cep;
		this.pais = pais;
		this.estado = estado;
	}

	public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Pais paisObjeto = paisRepository.findByNome(pais).get();
		Estado estadoObjeto = estadoRepository.findByNomeAndPais_Nome(estado, pais).get();
		Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, telefone, cep, paisObjeto, estadoObjeto);
		return cliente;
	}

	public String getPais() {
		return pais;
	}

	public String getEstado() {
		return estado;
	}
	
}
