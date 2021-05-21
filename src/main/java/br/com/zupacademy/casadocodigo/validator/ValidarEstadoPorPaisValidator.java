package br.com.zupacademy.casadocodigo.validator;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import br.com.zupacademy.casadocodigo.model.Estado;
import br.com.zupacademy.casadocodigo.model.Pais;
import br.com.zupacademy.casadocodigo.model.request.ClienteRequest;
import br.com.zupacademy.casadocodigo.repository.PaisRepository;

public class ValidarEstadoPorPaisValidator implements ConstraintValidator<ValidarEstadoPorPais, Object> {

	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		ClienteRequest request = (ClienteRequest) value;
		
		Optional<Pais> existePais = paisRepository.findByNome(request.getPais());
		Assert.state(!existePais.isEmpty(), "Esse país não está cadastrado");
		
		Assert.state(!request.getEstado().isBlank(), "Um estado deve ser selecionado");
		
		Pais pais = existePais.get();
		for(Estado e : pais.getEstados()) {
			if(e.getNome().equals(request.getEstado())) {
				return true;
			}
		}

		throw new IllegalStateException("Esse Estado não está cadastrado neste País");
	}

}
