package com.balancaunama.project.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balancaunama.project.entities.Usuario;
import com.balancaunama.project.repositories.UsuarioRepository;
import com.balancaunama.project.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioServices {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> object = usuarioRepository.findById(id);
		
		return object.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Usuario insert(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario update(Long id, Usuario usuario) {
		try {
			Usuario entity = usuarioRepository.getById(id);
			updateData(entity, usuario);
			return usuarioRepository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Usuario entity, Usuario usuario) {
		entity.setNome(usuario.getNome());
		entity.setLogin(usuario.getLogin());
		entity.setEmail(usuario.getEmail());
		entity.setPassword(usuario.getPassword());
		entity.setSetor(usuario.getSetor());
		entity.setVeiculo(usuario.getVeiculo());
	}
}
