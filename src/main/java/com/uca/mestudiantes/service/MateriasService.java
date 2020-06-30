package com.uca.mestudiantes.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;

import com.uca.mestudiantes.domain.Materias;

public interface MateriasService {
	
	public List<Materias> findAll() throws DataAccessException;

	public List<Materias> findAll(Sort sort);

	public Materias findOne(Integer codigo) throws DataAccessException;

	public void save(Materias c) throws DataAccessException;

	public void updateMaterias(Materias c);
	
	public int insertar(Materias c);

}
