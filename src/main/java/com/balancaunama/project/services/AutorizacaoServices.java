package com.balancaunama.project.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.balancaunama.project.entities.Autorizacao;
import com.balancaunama.project.repositories.AutorizacaoRepository;
import com.balancaunama.project.services.exceptions.ResourceNotFoundException;

public class AutorizacaoServices {

	@Autowired
	AutorizacaoRepository repository;

	public List<Autorizacao> findAll() {
		return repository.findAll();
	}
	
	public Autorizacao insert(Autorizacao autorizacao) {
		return repository.save(autorizacao);
	}
	
	public Autorizacao update(Long id, Autorizacao autorizacao) {
		try {
			Autorizacao entity = repository.getById(id);
			updateData(entity, autorizacao);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Autorizacao entity, Autorizacao autorizacao) {
		entity.setAgendamento(autorizacao.getAgendamento());
		entity.setUsingDate(autorizacao.getUsingDate());
	}
}
