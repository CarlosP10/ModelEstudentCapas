package com.uca.mestudiantes.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.uca.mestudiantes.dao.MunicipioDAO;
import com.uca.mestudiantes.domain.Municipio;
import com.uca.mestudiantes.repository.Municipioepository;
import com.uca.mestudiantes.service.MunicipioService;

@Service
public class MunicipioServiceImpl implements MunicipioService{
	
	@Autowired
	MunicipioDAO municipioDao;
	
	@Autowired
	Municipioepository municipioRepository;
	
	@PersistenceContext(unitName = "mestudiantes")
	EntityManager entityManager;

	@Override
	public List<Municipio> findAll() throws DataAccessException {
		return municipioRepository.findAllMuni();
	}

	@Override
	public List<Municipio> findAll(Sort sort) {
		return municipioRepository.findAll(sort);
	}

	@Override
	public void save(Municipio c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMunicipio(Municipio c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Municipio> findbyDpto(Integer codigo) throws DataAccessException {
		return municipioRepository.findMuniByIdDpto(codigo);
	}

}
