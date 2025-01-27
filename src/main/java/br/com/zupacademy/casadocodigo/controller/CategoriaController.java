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

import br.com.zupacademy.casadocodigo.model.Categoria;
import br.com.zupacademy.casadocodigo.model.dto.CategoriaDto;
import br.com.zupacademy.casadocodigo.model.request.CategoriaRequest;
import br.com.zupacademy.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<CategoriaDto> listAll() {
		List<Categoria> categorias = categoriaRepository.findAll();
		return CategoriaDto.converter(categorias);
	}
	
	@PostMapping
	public CategoriaDto save(@RequestBody @Valid CategoriaRequest categoriaRequest) {
		Categoria categoria = categoriaRequest.toModel();
		categoriaRepository.save(categoria);
		return new CategoriaDto(categoria);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
