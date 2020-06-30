package com.uca.mestudiantes.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;

import com.uca.mestudiantes.domain.Expediente;

public interface ExpedienteService {
	
	public List<Expediente> findAll() throws DataAccessException;

	public List<Expediente> findAll(Sort sort);

	public Expediente findOne(Integer codigo) throws DataAccessException;
	
	public Expediente findByName(String nombre) throws DataAccessException;
	
	public Expediente findByLastName(String aoellido) throws DataAccessException;

	public void save(Expediente c) throws DataAccessException;

	public void updateExpediente(Expediente c);
	
	public int insertar(Expediente c);

}
