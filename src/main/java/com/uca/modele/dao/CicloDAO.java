package com.uca.modele.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.uca.modele.domain.Ciclo;

public interface CicloDAO {
	
	public List<Ciclo> findAll() throws DataAccessException;
	
	public Ciclo findOne(Integer code) throws DataAccessException;


}
