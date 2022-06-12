package com.balancaunama.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balancaunama.project.entities.Porto;
import com.balancaunama.project.repositories.PortoRepository;

@Service
public class PortoServices {
	
	@Autowired
	PortoRepository repository;
	
	public List<Porto> findAll(){
		return repository.findAll();
	}
	
	public Porto insert(Porto porto) {
		return repository.save(porto);
	}
}
