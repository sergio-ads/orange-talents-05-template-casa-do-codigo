package br.com.zupacademy.casadocodigo.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

import br.com.zupacademy.casadocodigo.model.request.EstadoRequest;

public class UnicoEstadoPorPaisValidator implements ConstraintValidator<UnicoEstadoPorPais, EstadoRequest> {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public void initialize(UnicoEstadoPorPais params) {
	}
	
	@Override
	public boolean isValid(EstadoRequest estado, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from Estado e where e.nome=:nome AND e.pais.nome=:paisNome");
		query.setParameter("nome", estado.getNome());
		query.setParameter("paisNome", estado.getPais());
		List<?> list = query.getResultList();		
		Assert.state(list.size() <= 1, "O estado deve ser único por país");
		return list.isEmpty();
	}	

}
