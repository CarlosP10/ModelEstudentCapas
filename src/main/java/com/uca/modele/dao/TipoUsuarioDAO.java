package com.uca.modele.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.uca.modele.domain.Expediente;
import com.uca.modele.domain.TipoUsuario;

public interface TipoUsuarioDAO {
	
	public List<TipoUsuario> findAll() throws DataAccessException;	
	public TipoUsuario findOne(Integer code) throws DataAccessException;
	public void insertar(TipoUsuario c) throws DataAccessException;	
	public void save(TipoUsuario c) throws DataAccessException;
	public void updateTipoUsuario(TipoUsuario c);

}
