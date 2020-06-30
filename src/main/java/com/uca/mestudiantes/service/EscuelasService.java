package com.uca.mestudiantes.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;

import com.uca.mestudiantes.domain.Escuelas;

public interface EscuelasService {

	public List<Escuelas> findAll() throws DataAccessException;
	
	public List<Escuelas> findAllCatalogo() throws DataAccessException;

	public List<Escuelas> findAll(Sort sort);

	public Escuelas findOne(Integer codigo) throws DataAccessException;
	
	public List<Escuelas> findOnebyDpto(Integer codigo) throws DataAccessException;

	public void save(Escuelas c) throws DataAccessException;

	public void updateEscuelas(Escuelas c);
	
	public int insertar(Escuelas c);
	
	
}
