package com.balancaunama.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balancaunama.project.entities.Setor;
import com.balancaunama.project.repositories.SetorRepository;
import com.balancaunama.project.services.exceptions.ResourceNotFoundException;

@Service
public class SetorServices {
	
	@Autowired
	SetorRepository setorRepository;
	
	public List<Setor> findAll(){
		return setorRepository.findAll();
	}
	
	public Setor findById(Long id) {
		Optional<Setor> object = setorRepository.findById(id);
		
		return object.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
