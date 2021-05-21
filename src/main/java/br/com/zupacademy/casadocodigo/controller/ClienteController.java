package br.com.zupacademy.casadocodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.casadocodigo.model.Cliente;
import br.com.zupacademy.casadocodigo.model.dto.ClienteDto;
import br.com.zupacademy.casadocodigo.model.request.ClienteRequest;
import br.com.zupacademy.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	public List<ClienteDto> listAll() {
		List<Cliente> clientees = clienteRepository.findAll();
		return ClienteDto.converter(clientees);
	}
	
	@PostMapping
	public ClienteDto save(@RequestBody @Valid ClienteRequest clienteRequest) {
		Cliente cliente = clienteRequest.toModel(paisRepository, estadoRepository);
		clienteRepository.save(cliente);
		return new ClienteDto(cliente);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		clienteRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
