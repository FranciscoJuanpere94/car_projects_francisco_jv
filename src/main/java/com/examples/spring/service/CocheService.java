package com.examples.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examples.spring.model.Persona;
import com.examples.spring.repository.PersonaRepository;

@Service
public class CocheService {
	
	@Autowired
    CocheRepository cocheRepository;
	
	@Transactional
	public List<coche> getcoche(){
		return cocheRepository.findAll();
	}
	@Transactional
	public coche getPersonByUsername(String username){
		return cocheRepository.findByUsername(username);
	}

	@Transactional
	public coche savePerson(coche car){
		return cocheRepository.save(car);
	}
	
	@Transactional
   public void deletePersonByUsername(String coche){
	   Coche coche = cocheRepository.findByUsername(coche);
	   cocheRepository.delete(coche);
	}
}
