package com.uca.modele.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.modele.domain.Municipio;

public interface MunicipioDAO {
	
	public List<Municipio> findAll() throws DataAccessException;	
	public Municipio findOne(Integer code) throws DataAccessException;

}
