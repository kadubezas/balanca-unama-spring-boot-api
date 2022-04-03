package com.balancaunama.project.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balancaunama.project.entities.Veiculo;
import com.balancaunama.project.services.VeiculoServices;

@RestController
@RequestMapping(value="/veiculos")
public class VeiculoResource {

	@Autowired
	VeiculoServices services;
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAll(){
		List<Veiculo> list = services.findAll();
		
		return ResponseEntity.ok().body(list);
	}
}
