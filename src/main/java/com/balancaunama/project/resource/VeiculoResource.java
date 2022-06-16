package com.balancaunama.project.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.balancaunama.project.entities.Veiculo;
import com.balancaunama.project.services.VeiculoServices;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {

	@Autowired
	VeiculoServices services;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAll() {
		List<Veiculo> list = services.findAll();

		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Veiculo> insert(@RequestBody Veiculo veiculo) {
		veiculo = services.insert(veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(veiculo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(veiculo);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Veiculo> update(@PathVariable Long id, @RequestBody Veiculo veiculo){
		veiculo = services.update(id, veiculo);
		return ResponseEntity.ok().body(veiculo);
	}
	
	@PutMapping(value = "/atualizarTara/{id}")
	public ResponseEntity<Veiculo> updateTara(@PathVariable Long id, @RequestParam float tara){
		Veiculo veiculo = services.updateTara(id, tara);
		
		return ResponseEntity.ok().body(veiculo);
	}
	
}