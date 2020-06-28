package com.uca.mestudiantes.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.mestudiantes.domain.Escuelas;

public interface EscuelasDAO {
	public List<Escuelas> findAll() throws DataAccessException;	
	public Escuelas findOne(Integer code) throws DataAccessException;
	public void insertar(Escuelas c) throws DataAccessException;	

}
