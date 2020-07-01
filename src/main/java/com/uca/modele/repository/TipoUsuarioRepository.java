package com.uca.modele.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.modele.domain.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{
	
	@Query(value = "SELECT * from public.tipo_usuario", nativeQuery = true)
    public List<TipoUsuario> findAllTipos();

	public List<TipoUsuario> findAll(Sort sort);
	
}


