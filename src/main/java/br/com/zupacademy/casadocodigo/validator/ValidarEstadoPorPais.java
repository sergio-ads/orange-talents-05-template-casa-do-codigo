package br.com.zupacademy.casadocodigo.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ValidarEstadoPorPaisValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidarEstadoPorPais {

	String message() default "";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };

}