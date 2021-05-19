package br.com.zupacademy.casadocodigo.controller;

 import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.casadocodigo.dto.AutorDto;
import br.com.zupacademy.casadocodigo.dto.AutorRequest;
import br.com.zupacademy.casadocodigo.model.Autor;
import br.com.zupacademy.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.casadocodigo.validator.EmailUniqueValidator;

@RestController
@RequestMapping(value = "/autor")
public class AutoresController {
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private EmailUniqueValidator emailUniqueValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(emailUniqueValidator);
	}
	
	@GetMapping
	public List<Autor> listAll() {
		List<Autor> autores = autorRepository.findAll();
		return autores;
	}
	
	@PostMapping
	public AutorDto save(@RequestBody @Valid AutorRequest autorRequest) {
		Autor autor = autorRequest.toModel();
		autorRepository.save(autor);
		return new AutorDto(autor);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		autorRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
