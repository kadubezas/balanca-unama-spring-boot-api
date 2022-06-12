package com.balancaunama.project.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balancaunama.project.entities.Porto;
import com.balancaunama.project.services.PortoServices;

@RestController
@RequestMapping(value = "/portos")
public class PortoResource {
	
	@Autowired
	PortoServices service;
	
	@GetMapping
	public ResponseEntity<List<Porto>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
}
