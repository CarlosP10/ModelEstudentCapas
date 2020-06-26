package com.uca.mestudiantes.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.mestudiantes.domain.Expediente;

public interface ExpedienteDAO {
	
	public List<Expediente> findAll() throws DataAccessException;	
	public Expediente findOne(Integer code) throws DataAccessException;
	public void insertar(Expediente c) throws DataAccessException;	

}
