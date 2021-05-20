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

import br.com.zupacademy.casadocodigo.model.Estado;
import br.com.zupacademy.casadocodigo.model.dto.EstadoDto;
import br.com.zupacademy.casadocodigo.model.request.EstadoRequest;
import br.com.zupacademy.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping(value = "/estado")
public class EstadoController {
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping
	public List<EstadoDto> listAll() {
		List<Estado> estados = estadoRepository.findAll();
		return EstadoDto.converter(estados);
	}
	
	@PostMapping
	public EstadoDto save(@RequestBody @Valid EstadoRequest estadoRequest) {
		Estado estado = estadoRequest.toModel(paisRepository);
		estadoRepository.save(estado);
		return new EstadoDto(estado);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		estadoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
