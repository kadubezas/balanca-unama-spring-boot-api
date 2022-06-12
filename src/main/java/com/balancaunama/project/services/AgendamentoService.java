package com.balancaunama.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balancaunama.project.entities.Agendamento;
import com.balancaunama.project.repositories.AgendamentoRepository;
import com.balancaunama.project.services.exceptions.ResourceNotFoundException;

@Service
public class AgendamentoService {
	
	@Autowired
	AgendamentoRepository repository;
	
	public List<Agendamento> findAll(){
		return repository.findAll();
	}
	
	public Agendamento insert(Agendamento agendamento) {
		return repository.save(agendamento);
	}
	
	public Agendamento findById(long id) {
		Optional<Agendamento> object = repository.findById(id);
		
		return object.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
