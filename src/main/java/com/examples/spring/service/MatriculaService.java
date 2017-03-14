package com.examples.spring.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examples.spring.model.Provincia;
import com.examples.spring.repository.ProvinciaRepository;
@Service
public class MatriculaService {
	
	@Autowired
	ProvinciaRepository ProvinciaRepository;
	
	@Transactional
	public List<Provincia> provinciaFindAll(){
		List<Provincia> provincias = ProvinciaRepository.findAll();
		Collections.sort(provincias);
		return provincias;
		
	}
}
