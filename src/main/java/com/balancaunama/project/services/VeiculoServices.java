package com.balancaunama.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balancaunama.project.entities.Veiculo;
import com.balancaunama.project.repositories.VeiculoRepository;
import com.balancaunama.project.services.exceptions.ResourceNotFoundException;

@Service
public class VeiculoServices {
	
	@Autowired
	VeiculoRepository repository;
	
	public List<Veiculo> findAll(){
		return repository.findAll();
	}
	
	public Veiculo findById(Long id) {
		Optional<Veiculo> object = repository.findById(id);
		
		return object.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Veiculo insert(Veiculo veiculo) {
		return repository.save(veiculo);
	}
}
