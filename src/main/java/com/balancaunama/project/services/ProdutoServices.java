package com.balancaunama.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balancaunama.project.entities.Produto;
import com.balancaunama.project.repositories.ProdutoRepository;
import com.balancaunama.project.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoServices {
	
	@Autowired
	ProdutoRepository repository;
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(long id) {
		Optional<Produto> object = repository.findById(id);
		
		return object.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Produto insert(Produto produto) {
		return repository.save(produto);
	}
}
