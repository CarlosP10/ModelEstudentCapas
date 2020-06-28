package com.uca.mestudiantes.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.mestudiantes.domain.Municipio;

public interface MunicipioDAO {
	
	public List<Municipio> findAll() throws DataAccessException;	
	public Municipio findOne(Integer code) throws DataAccessException;

}
