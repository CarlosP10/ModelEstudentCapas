package com.uca.mestudiantes.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;

import com.uca.mestudiantes.domain.Departamento;

public interface DepartamentoService {
	
	public List<Departamento> findAll() throws DataAccessException;

	public List<Departamento> findAll(Sort sort);

	public Departamento findOne(Integer codigo) throws DataAccessException;

	public void save(Departamento c) throws DataAccessException;

	public void updateDepartamento(Departamento c);

}
