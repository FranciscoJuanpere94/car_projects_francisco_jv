package com.examples.spring.controller.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.examples.spring.model.Persona;
import com.examples.spring.repository.PersonaRepository;

@Component
public class CocheHelper {
	
	@Autowired
	CocheRepository CocheRepository;

	
	
	public boolean userAlreadyExists(Coche coche, BindingResult result) {
		if (CocheRepository.findByUsername(coche.getUsername())==null){
			return false;
			
		}else{
			result.rejectValue("userCoche", "userAlreadyExists");
			return true;
		}
	}
	
	

}
