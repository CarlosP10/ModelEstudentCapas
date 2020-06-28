package com.uca.mestudiantes.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.mestudiantes.domain.TipoUsuario;

public interface TipoUsuarioDAO {
	
	public List<TipoUsuario> findAll() throws DataAccessException;	
	public TipoUsuario findOne(Integer code) throws DataAccessException;

}
