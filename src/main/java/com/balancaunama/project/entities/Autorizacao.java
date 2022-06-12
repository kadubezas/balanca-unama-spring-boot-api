package com.balancaunama.project.entities;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_autorizacao")
public class Autorizacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Timestamp usingDate;
	
	@ManyToOne
	@JoinColumn(name = "id_agendamento")
	private Agendamento agendamento;
	
	public Autorizacao() {
		
	}

	public Autorizacao(Long id, Timestamp usingDate, Agendamento agendamento) {
		super();
		this.id = id;
		this.usingDate = usingDate;
		this.agendamento = agendamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getUsingDate() {
		return usingDate;
	}

	public void setUsingDate(Timestamp usingDate) {
		this.usingDate = usingDate;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
}
