package br.com.zupacademy.casadocodigo.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.casadocodigo.model.Cliente;

public class ClienteDto {
	private String email;
	private String nome;
	private String sobrenome;
	private String documento;
	private String endereco;
	private String complemento;
	private String cidade;
	private String telefone;
	private String cep;
	private PaisDto pais;
	private EstadoDto estado;	
	
	public ClienteDto(Cliente cliente) {
		this.email = cliente.getEmail();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.documento = cliente.getDocumento();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.telefone = cliente.getTelefone();
		this.cep = cliente.getCep();
		this.pais = new PaisDto(cliente.getPais());
		this.estado = new EstadoDto(cliente.getEstado());
	}

	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}	
	
	public String getEmail() {
		return email;
	}
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public String getDocumento() {
		return documento;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getCep() {
		return cep;
	}
	public PaisDto getPais() {
		return pais;
	}
	public EstadoDto getEstado() {
		return estado;
	}
	
}
