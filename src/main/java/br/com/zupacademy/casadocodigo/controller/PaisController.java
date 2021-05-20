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

import br.com.zupacademy.casadocodigo.model.Pais;
import br.com.zupacademy.casadocodigo.model.dto.PaisDto;
import br.com.zupacademy.casadocodigo.model.request.PaisRequest;
import br.com.zupacademy.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping(value = "/pais")
public class PaisController {
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping
	public List<PaisDto> listAll() {
		List<Pais> paises = paisRepository.findAll();
		return PaisDto.converter(paises);
	}
	
	@PostMapping
	public PaisDto save(@RequestBody @Valid PaisRequest paisRequest) {
		Pais pais = paisRequest.toModel();
		paisRepository.save(pais);
		return new PaisDto(pais);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		paisRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
