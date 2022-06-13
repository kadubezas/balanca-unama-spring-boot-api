package com.balancaunama.project.config;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.balancaunama.project.entities.Agendamento;
import com.balancaunama.project.entities.Autorizacao;
import com.balancaunama.project.entities.Pesagem;
import com.balancaunama.project.entities.PesoBalanca;
import com.balancaunama.project.entities.Porto;
import com.balancaunama.project.entities.Produto;
import com.balancaunama.project.entities.Setor;
import com.balancaunama.project.entities.Usuario;
import com.balancaunama.project.entities.Veiculo;
import com.balancaunama.project.repositories.AgendamentoRepository;
import com.balancaunama.project.repositories.AutorizacaoRepository;
import com.balancaunama.project.repositories.PesagemRepository;
import com.balancaunama.project.repositories.PesoBalancaRepository;
import com.balancaunama.project.repositories.PortoRepository;
import com.balancaunama.project.repositories.ProdutoRepository;
import com.balancaunama.project.repositories.SetorRepository;
import com.balancaunama.project.repositories.UsuarioRepository;
import com.balancaunama.project.repositories.VeiculoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	SetorRepository setorRepository;

	@Autowired
	VeiculoRepository veiculoRepository;

	@Autowired
	PesoBalancaRepository pesoRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	PortoRepository portoRepository;

	@Autowired
	AutorizacaoRepository autorizacaoRepository;

	@Autowired
	PesagemRepository pesagemRepository;

	@Autowired
	AgendamentoRepository agendamentoRepository;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void run(String... args) throws Exception {

		Setor setor1 = new Setor(null, "Administração");
		Setor setor2 = new Setor(null, "Balança");

		Veiculo veiculo1 = new Veiculo(null, "RTX3080", null, "Fiat", "Rosa");

		setorRepository.saveAll(Arrays.asList(setor1, setor2));

		veiculoRepository.save(veiculo1);

		Usuario usuario1 = new Usuario(null, "Carlos Eduardo da Silva Mesquita", "kadubezas", "kadubezas@gmail.com",
				"12345678", true, setor1, veiculo1);

		Usuario usuario2 = new Usuario(null, "Richard Aquino", "ri_chard", "richard@gmail.com", "123456sd78", true,
				setor2, null);

		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));

		PesoBalanca peso1 = new PesoBalanca(null, Timestamp.valueOf(sdf.format(new Date())), 14000.0F);
		PesoBalanca peso2 = new PesoBalanca(null, Timestamp.valueOf(sdf.format(new Date())), 9000.0F);

		pesoRepository.saveAll(Arrays.asList(peso1, peso2));

		Produto produto = new Produto(null, "Madeira");
		Produto produto2 = new Produto(null, "Ferro");
		Produto produto3 = new Produto(null, "Aço");

		produtoRepository.saveAll(Arrays.asList(produto, produto2, produto3));

		Porto porto = new Porto(null, "Vila do Conde");
		Porto porto2 = new Porto(null, "Santarém");
		Porto porto3 = new Porto(null, "Miramar");

		portoRepository.saveAll(Arrays.asList(porto, porto2, porto3));

		Agendamento agendamento = new Agendamento(null, 15200F, porto, produto, null);

		agendamentoRepository.save(agendamento);

		Autorizacao autorizacao = new Autorizacao(null, null, agendamento);
		Autorizacao autorizacao2 = new Autorizacao(null, null, agendamento);
		Autorizacao autorizacao3 = new Autorizacao(null, null, agendamento);
		Autorizacao autorizacao4 = new Autorizacao(null, null, agendamento);

		autorizacaoRepository.saveAll(Arrays.asList(autorizacao, autorizacao2, autorizacao3, autorizacao4));

		Pesagem pesagem = new Pesagem(null, 13000F, 9000F, Timestamp.valueOf(sdf.format(new Date())), Timestamp.valueOf(sdf.format(new Date())), autorizacao,
				veiculo1);
		
		pesagemRepository.save(pesagem);
		
		autorizacao.setUsingDate(Timestamp.valueOf(sdf.format(new Date())));
		
		autorizacaoRepository.save(autorizacao);
	}
}
