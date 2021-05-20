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

import br.com.zupacademy.casadocodigo.model.Livro;
import br.com.zupacademy.casadocodigo.model.dto.LivroDetalhadoDto;
import br.com.zupacademy.casadocodigo.model.dto.LivroSimplesDto;
import br.com.zupacademy.casadocodigo.model.request.LivroRequest;
import br.com.zupacademy.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private CategoriaRepository categoriaRepository; 
	@Autowired
	private AutorRepository autorRepository;
	
	@GetMapping
	public List<LivroSimplesDto> listAll() {
		List<Livro> livros = livroRepository.findAll();
		return LivroSimplesDto.converter(livros);
	}
	
	@PostMapping
	public LivroDetalhadoDto save(@RequestBody @Valid LivroRequest livroRequest) {
		Livro livro = livroRequest.toModel(categoriaRepository, autorRepository);
		livroRepository.save(livro);
		return new LivroDetalhadoDto(livro);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		livroRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
