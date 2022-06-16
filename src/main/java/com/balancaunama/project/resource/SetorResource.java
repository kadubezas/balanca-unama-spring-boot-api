package com.balancaunama.project.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balancaunama.project.entities.Setor;
import com.balancaunama.project.services.SetorServices;

@RestController
@RequestMapping(value="/setores")
public class SetorResource {
	
	@Autowired
	SetorServices services;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Setor>> findAll(){
		List<Setor> list = services.findAll();
		
		return ResponseEntity.ok().body(list);
	}
}
