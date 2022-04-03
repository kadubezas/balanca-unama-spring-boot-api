package com.balancaunama.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.balancaunama.project.entities.Setor;
import com.balancaunama.project.entities.Usuario;
import com.balancaunama.project.entities.Veiculo;
import com.balancaunama.project.repositories.SetorRepository;
import com.balancaunama.project.repositories.UsuarioRepository;
import com.balancaunama.project.repositories.VeiculoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	SetorRepository setorRepository;
	
	@Autowired
	VeiculoRepository veiculoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Setor setor1 = new Setor(null, "Administração");
		Setor setor2 = new Setor(null, "Balança");
		
		setorRepository.saveAll(Arrays.asList(setor1, setor2));
		
		Usuario usuario1 = new Usuario(null, "Carlos Eduardo da Silva Mesquita", "kadubezas", "kadubezas@gmail.com", "12345678", true, setor1);
		
		Usuario usuario2 = new Usuario(null, "Richar Chupa Pinto", "ri_chard", "richard@gmail.com", "123456sd78", true, setor2);
		
		usuarioRepository.saveAll(Arrays.asList(usuario1,usuario2));
		
		Veiculo veiculo1 = new Veiculo(null, "RTX3080", "Fiat", "Rosa", usuario2);
		
		veiculoRepository.saveAll(Arrays.asList(veiculo1));
		
		usuario2.setVeiculo(veiculo1);
		
		usuarioRepository.save(usuario2);
	}
}
