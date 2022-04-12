package com.balancaunama.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.balancaunama.project.entities.PesoBalanca;

public interface PesoBalancaRepository extends JpaRepository<PesoBalanca, Long>{
	
	
	@Query(value = "SELECT * FROM tb_peso ORDER BY id DESC LIMIT 1", nativeQuery = true)
	PesoBalanca findLast();
}
