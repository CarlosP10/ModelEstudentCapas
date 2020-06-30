package com.uca.mestudiantes.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.uca.mestudiantes.domain.Expediente;
import com.uca.mestudiantes.domain.TipoUsuario;

public interface TipoUsuarioDAO {
	
	public List<TipoUsuario> findAll() throws DataAccessException;	
	public TipoUsuario findOne(Integer code) throws DataAccessException;
	public void insertar(TipoUsuario c) throws DataAccessException;	
	public void save(TipoUsuario c) throws DataAccessException;
	public void updateTipoUsuario(TipoUsuario c);

}
