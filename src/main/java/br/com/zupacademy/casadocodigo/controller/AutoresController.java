package br.com.zupacademy.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.casadocodigo.dto.AutorDto;
import br.com.zupacademy.casadocodigo.dto.AutorRequest;
import br.com.zupacademy.casadocodigo.model.Autor;
import br.com.zupacademy.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping(value = "/autor")
public class AutoresController {
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	public AutorDto save(@RequestBody @Valid AutorRequest autorRequest) {
		Autor autor = autorRequest.toModel();
		autorRepository.save(autor);
		return new AutorDto(autor);
	}

}
