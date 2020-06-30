package com.uca.mestudiantes.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.uca.mestudiantes.domain.Expediente;
import com.uca.mestudiantes.domain.Materias;

public interface MateriasDAO {
	public List<Materias> findAll() throws DataAccessException;	
	public Materias findOne(Integer code) throws DataAccessException;
	public void insertar(Materias c) throws DataAccessException;	
	public void save(Materias c) throws DataAccessException;
	public void updateMaterias(Materias c);

}
