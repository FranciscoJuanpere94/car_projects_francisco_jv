package com.examples.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.examples.spring.model.Persona;

@Component
public class CocheValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
        return coche.class.equals(clazz);
    }

	@Override
	public void validate(Object object, Errors errors) {
		Coche coche = (Coche) object;
		
		if (coche.getMatricula() == null || coche.getMatricula().getId() == 0) {
            errors.rejectValue("provincia", "province.selectAnOption");
        }
		if (coche.getCoche().equals("Seat")) {
            errors.rejectValue("nombre", "nombre.Seat");
        
		
	}

}
