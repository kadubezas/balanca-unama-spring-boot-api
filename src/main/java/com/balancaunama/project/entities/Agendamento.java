package com.balancaunama.project.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_agendamento")
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Float pesoTotal;
	
	@ManyToOne
	@JoinColumn(name = "id_porto")
	private Porto porto;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	@OneToMany(mappedBy = "agendamento")
	@JsonIgnore
	private List<Autorizacao> autorizacoes;

	public Agendamento(Long id, Float pesoTotal, Porto porto, Produto produto, List<Autorizacao> autorizacoes) {
		super();
		this.id = id;
		this.pesoTotal = pesoTotal;
		this.porto = porto;
		this.produto = produto;
		this.autorizacoes = autorizacoes;
	}
	
	public Agendamento() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(Float pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public Porto getPorto() {
		return porto;
	}

	public void setPorto(Porto porto) {
		this.porto = porto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}
}
