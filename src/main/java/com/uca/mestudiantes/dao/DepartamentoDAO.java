package com.uca.mestudiantes.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.uca.mestudiantes.domain.Departamento;

public interface DepartamentoDAO {
	
	public List<Departamento> findAll() throws DataAccessException;	
	public Departamento findOne(Integer code) throws DataAccessException;

}
