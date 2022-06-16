package com.balancaunama.project.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balancaunama.project.entities.Agendamento;
import com.balancaunama.project.services.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoResource {

	@Autowired
	AgendamentoService service;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Agendamento>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
}
