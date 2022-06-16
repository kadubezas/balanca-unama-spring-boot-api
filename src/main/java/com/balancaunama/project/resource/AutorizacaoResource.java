package com.balancaunama.project.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balancaunama.project.entities.Autorizacao;
import com.balancaunama.project.services.AutorizacaoServices;

@RestController
@RequestMapping(value = "/autorizacoes")
public class AutorizacaoResource {
	
	@Autowired
	AutorizacaoServices service;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Autorizacao>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
}
