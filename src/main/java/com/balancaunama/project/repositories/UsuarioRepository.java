package com.balancaunama.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balancaunama.project.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}
