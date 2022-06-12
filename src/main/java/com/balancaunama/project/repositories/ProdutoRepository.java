package com.balancaunama.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balancaunama.project.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
