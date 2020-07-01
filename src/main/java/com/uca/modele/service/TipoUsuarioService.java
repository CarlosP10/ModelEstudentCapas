package com.uca.modele.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;

import com.uca.modele.domain.TipoUsuario;

public interface TipoUsuarioService {
	
	public List<TipoUsuario> findAll() throws DataAccessException;

	public List<TipoUsuario> findAll(Sort sort);

	public TipoUsuario findOne(Integer codigo) throws DataAccessException;

	public void save(TipoUsuario c) throws DataAccessException;

	public void updateTipoUsuario(TipoUsuario c);
	
	public int insertar(TipoUsuario c);

}
