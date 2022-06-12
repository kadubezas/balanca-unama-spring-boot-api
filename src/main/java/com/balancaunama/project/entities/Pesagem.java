package com.balancaunama.project.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pesagem")
public class Pesagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Float primeiraPesagem;
	private Float segundaPesagem;
	private Timestamp dataPrimeiraPesagem;
	private Timestamp dataSegundaPesagem;
	
	@OneToOne
	@JoinColumn(name = "id_autorizacao")
	private Autorizacao autorizacao;
	
	@ManyToOne
	@JoinColumn(name = "id_veiculo")
	private Veiculo veiculo;
	
	public Pesagem() {
		
	}

	public Pesagem(Long id, Float primeiraPesagem, Float segundaPesagem, Timestamp dataPrimeiraPesagem,
			Timestamp dataSegundaPesagem, Autorizacao autorizacao, Veiculo veiculo) {
		super();
		this.id = id;
		this.primeiraPesagem = primeiraPesagem;
		this.segundaPesagem = segundaPesagem;
		this.dataPrimeiraPesagem = dataPrimeiraPesagem;
		this.dataSegundaPesagem = dataSegundaPesagem;
		this.autorizacao = autorizacao;
		this.veiculo = veiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPrimeiraPesagem() {
		return primeiraPesagem;
	}

	public void setPrimeiraPesagem(Float primeiraPesagem) {
		this.primeiraPesagem = primeiraPesagem;
	}

	public Float getSegundaPesagem() {
		return segundaPesagem;
	}

	public void setSegundaPesagem(Float segundaPesagem) {
		this.segundaPesagem = segundaPesagem;
	}

	public Timestamp getDataPrimeiraPesagem() {
		return dataPrimeiraPesagem;
	}

	public void setDataPrimeiraPesagem(Timestamp dataPrimeiraPesagem) {
		this.dataPrimeiraPesagem = dataPrimeiraPesagem;
	}

	public Timestamp getDataSegundaPesagem() {
		return dataSegundaPesagem;
	}

	public void setDataSegundaPesagem(Timestamp dataSegundaPesagem) {
		this.dataSegundaPesagem = dataSegundaPesagem;
	}

	public Autorizacao getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(Autorizacao autorizacao) {
		this.autorizacao = autorizacao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Float pesoLiquido() {
		return primeiraPesagem - segundaPesagem;
	}
}
