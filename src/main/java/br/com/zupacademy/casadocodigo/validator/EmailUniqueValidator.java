package br.com.zupacademy.casadocodigo.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.casadocodigo.dto.AutorRequest;
import br.com.zupacademy.casadocodigo.model.Autor;
import br.com.zupacademy.casadocodigo.repository.AutorRepository;

@Component
public class EmailUniqueValidator implements Validator {
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {	
		if(errors.hasErrors())
			return;

		AutorRequest request = (AutorRequest) target;
		Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());
		if(autor.isPresent())
			errors.rejectValue("email", null, "Já existe outro(a) autor(a) com esse e-mail: " +request.getEmail());
	}

}
