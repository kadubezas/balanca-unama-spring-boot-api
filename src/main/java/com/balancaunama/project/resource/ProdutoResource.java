package com.balancaunama.project.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.balancaunama.project.entities.Produto;
import com.balancaunama.project.services.ProdutoServices;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	ProdutoServices service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Produto> insert(@RequestBody Produto produto){
		produto = service.insert(produto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(produto);
	}
}
