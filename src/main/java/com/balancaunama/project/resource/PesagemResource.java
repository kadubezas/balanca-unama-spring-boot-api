package com.balancaunama.project.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balancaunama.project.entities.Pesagem;
import com.balancaunama.project.services.PesagemServices;

@RestController
@RequestMapping(value = "/pesagens")
public class PesagemResource {
	
	@Autowired
	PesagemServices service;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Pesagem>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
}
