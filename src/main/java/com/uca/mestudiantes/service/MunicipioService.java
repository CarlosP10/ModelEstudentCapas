package com.uca.mestudiantes.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;

import com.uca.mestudiantes.domain.Municipio;

public interface MunicipioService {
	
	public List<Municipio> findAll() throws DataAccessException;

	public List<Municipio> findAll(Sort sort);

	public Municipio findOne(Integer codigo) throws DataAccessException;

	public void save(Municipio c) throws DataAccessException;

	public void updateMunicipio(Municipio c);

}
