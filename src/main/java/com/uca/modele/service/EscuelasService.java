package com.uca.modele.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.uca.modele.domain.Escuelas;

public interface EscuelasService {

	public List<Escuelas> findAll() throws DataAccessException;
	
	public List<Escuelas> findAllCatalogo() throws DataAccessException;
	
	public Page<Escuelas> findAll(Pageable page) throws DataAccessException;
	
	public Long countAll();

	public List<Escuelas> findAll(Sort sort);

	public Escuelas findOne(Integer codigo) throws DataAccessException;
	
	public List<Escuelas> findOnebyDpto(Integer codigo) throws DataAccessException;

	public void save(Escuelas c) throws DataAccessException;
	
	
}
