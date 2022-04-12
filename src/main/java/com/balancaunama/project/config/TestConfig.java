package com.balancaunama.project.config;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.balancaunama.project.entities.PesoBalanca;
import com.balancaunama.project.entities.Setor;
import com.balancaunama.project.entities.Usuario;
import com.balancaunama.project.entities.Veiculo;
import com.balancaunama.project.repositories.PesoBalancaRepository;
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
	
	@Autowired
	PesoBalancaRepository pesoRepository;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void run(String... args) throws Exception {
		
		Setor setor1 = new Setor(null, "Administração");
		Setor setor2 = new Setor(null, "Balança");
		
		Veiculo veiculo1 = new Veiculo(null, "RTX3080", "Fiat", "Rosa");
		
		setorRepository.saveAll(Arrays.asList(setor1, setor2));
		
		veiculoRepository.save(veiculo1);
		
		Usuario usuario1 = new Usuario(null, "Carlos Eduardo da Silva Mesquita", "kadubezas", "kadubezas@gmail.com", "12345678", true, setor1, veiculo1);
		
		Usuario usuario2 = new Usuario(null, "Richar Chupa Pinto", "ri_chard", "richard@gmail.com", "123456sd78", true, setor2, null);
		
		usuarioRepository.saveAll(Arrays.asList(usuario1,usuario2));
		
		PesoBalanca peso1 = new PesoBalanca(null, Timestamp.valueOf(sdf.format(new Date())) , 14000.0F);
		PesoBalanca peso2 = new PesoBalanca(null, Timestamp.valueOf(sdf.format(new Date())) , 9000.0F);
		
		pesoRepository.saveAll(Arrays.asList(peso1,peso2));
	}
}
