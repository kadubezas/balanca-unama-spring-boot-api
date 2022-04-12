package com.balancaunama.project.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_peso")
public class PesoBalanca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Timestamp dataPesagem;
	private Float peso;
	
	public PesoBalanca() {
		
	}

	public PesoBalanca(Long id, Timestamp dataPesagem, Float peso) {
		super();
		this.id = id;
		this.dataPesagem = dataPesagem;
		this.peso = peso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDataPesagem() {
		return dataPesagem;
	}

	public void setDataPesagem(Timestamp dataPesagem) {
		this.dataPesagem = dataPesagem;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}
}
