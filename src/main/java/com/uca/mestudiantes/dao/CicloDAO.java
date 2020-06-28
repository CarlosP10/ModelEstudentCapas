package com.uca.mestudiantes.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.uca.mestudiantes.domain.Ciclo;

public interface CicloDAO {
	
	public List<Ciclo> findAll() throws DataAccessException;
	
	public Ciclo findOne(Integer code) throws DataAccessException;

}
