package com.uca.modele.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;

import com.uca.modele.domain.Municipio;

public interface MunicipioService {
	
	public List<Municipio> findAll() throws DataAccessException;

	public List<Municipio> findAll(Sort sort);

	public List<Municipio> findbyDpto(Integer codigo) throws DataAccessException;

	public void save(Municipio c) throws DataAccessException;

	public void updateMunicipio(Municipio c);

	public Municipio findOne(Integer code) throws DataAccessException;
}
