package com.uca.modele.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;

import com.uca.modele.domain.Expediente;
import com.uca.modele.domain.MateriasxAlumno;

public interface ExpedienteService {
	
	public List<Expediente> findAll() throws DataAccessException;

	public List<Expediente> findAll(Sort sort);

	public Expediente findOne(Integer codigo) throws DataAccessException;
	
	public List<Expediente> findByName(String nombre) throws DataAccessException;
	
	public List<Expediente> findByLastName(String aoellido) throws DataAccessException;
	
	public List<Expediente> getQueryMethod(Integer tipo, String valor) throws Exception;
	
	public Long countAll();

	public void save(Expediente c) throws DataAccessException;

}
