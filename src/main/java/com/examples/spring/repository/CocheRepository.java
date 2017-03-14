package com.examples.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examples.spring.model.Persona;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer> {
	
	Coche findByUsername(String coche);
}
