package com.balancaunama.project.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.balancaunama.project.entities.PesoBalanca;
import com.balancaunama.project.services.PesoBalancaServices;

@RestController
@RequestMapping(value = "/peso")
public class PesoBalancaResource {
	
	@Autowired
	PesoBalancaServices services;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<PesoBalanca>> findAll(){
		List<PesoBalanca> list = services.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@CrossOrigin
	@GetMapping(value = "/last")
	public ResponseEntity<PesoBalanca> findLast(){
		PesoBalanca obj = services.findLast();
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<PesoBalanca> insert(@RequestBody PesoBalanca pesoBalanca){
		pesoBalanca = services.insert(pesoBalanca);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(pesoBalanca.getId()).toUri();
		return ResponseEntity.created(uri).body(pesoBalanca);
	}
}
