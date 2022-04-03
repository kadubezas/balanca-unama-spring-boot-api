package com.balancaunama.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.balancaunama.project.entities.Setor;
import com.balancaunama.project.entities.Usuario;
import com.balancaunama.project.repositories.SetorRepository;
import com.balancaunama.project.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	SetorRepository setorRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Setor setor1 = new Setor(null, "Administração");
		Setor setor2 = new Setor(null, "Balança");
		
		Usuario usuario1 = new Usuario(null, "Carlos Eduardo da Silva Mesquita", "kadubezas", "kadubezas@gmail.com", "12345678", true, setor1);
		
		setorRepository.saveAll(Arrays.asList(setor1, setor2));
		
		usuarioRepository.saveAll(Arrays.asList(usuario1));
	}
}
