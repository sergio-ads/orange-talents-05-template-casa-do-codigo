package br.com.zupacademy.casadocodigo.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.casadocodigo.dto.CategoriaRequest;
import br.com.zupacademy.casadocodigo.model.Categoria;
import br.com.zupacademy.casadocodigo.repository.CategoriaRepository;

@Component
public class NomeUniqueValidator implements Validator {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {	
		if(errors.hasErrors())
			return;

		CategoriaRequest request = (CategoriaRequest) target;
		Optional<Categoria> categoria = categoriaRepository.findByNome(request.getNome());
		if(categoria.isPresent())
			errors.rejectValue("nome", null, "Já existe outra categoria com esse nome: " +request.getNome());
	}

}
