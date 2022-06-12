package com.balancaunama.project.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balancaunama.project.entities.Pesagem;
import com.balancaunama.project.repositories.PesagemRepository;
import com.balancaunama.project.services.exceptions.ResourceNotFoundException;

@Service
public class PesagemServices {

	@Autowired
	PesagemRepository repository;

	public List<Pesagem> findAll() {
		return repository.findAll();
	}
	
	public Pesagem insert(Pesagem pesagem) {
		return repository.save(pesagem);
	}
	
	public Pesagem update(Long id, Pesagem pesagem) {
		try {
			Pesagem entity = repository.getById(id);
			updateData(entity, pesagem);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Pesagem entity, Pesagem pesagem) {
		entity.setPrimeiraPesagem(pesagem.getPrimeiraPesagem());
		entity.setDataPrimeiraPesagem(pesagem.getDataPrimeiraPesagem());
		entity.setSegundaPesagem(pesagem.getSegundaPesagem());
		entity.setDataSegundaPesagem(pesagem.getDataSegundaPesagem());
		entity.setAutorizacao(pesagem.getAutorizacao());
		entity.setVeiculo(pesagem.getVeiculo());
	}
}
