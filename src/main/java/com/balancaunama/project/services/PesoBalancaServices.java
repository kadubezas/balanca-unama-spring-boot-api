package com.balancaunama.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balancaunama.project.entities.PesoBalanca;
import com.balancaunama.project.repositories.PesoBalancaRepository;
import com.balancaunama.project.services.exceptions.ResourceNotFoundException;

@Service
public class PesoBalancaServices {
	
	@Autowired
	PesoBalancaRepository repository;
	
	public List<PesoBalanca> findAll(){
		return repository.findAll();
	}
	
	public PesoBalanca findLast() {
		return repository.findLast();
	}
	
	public PesoBalanca findById(Long id) {
		Optional<PesoBalanca> object = repository.findById(id);
		return object.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public PesoBalanca insert(PesoBalanca pesoBalanca) {
		return repository.save(pesoBalanca);
	}
}
