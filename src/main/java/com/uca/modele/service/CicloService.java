package com.uca.modele.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;


import com.uca.modele.domain.Ciclo;

public interface CicloService {
	
	public List<Ciclo> findAll() throws DataAccessException;

	public List<Ciclo> findAll(Sort sort);

	public Ciclo findOne(Integer codigo) throws DataAccessException;
}
