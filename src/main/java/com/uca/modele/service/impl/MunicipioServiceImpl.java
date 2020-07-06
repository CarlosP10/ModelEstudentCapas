package com.uca.modele.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.uca.modele.dao.MunicipioDAO;
import com.uca.modele.domain.Municipio;
import com.uca.modele.repository.Municipioepository;
import com.uca.modele.service.MunicipioService;

@Service
public class MunicipioServiceImpl implements MunicipioService{
	
	@Autowired
	MunicipioDAO municipioDao;
	
	@Autowired
	Municipioepository municipioRepository;
	
	@PersistenceContext(unitName = "modele")
	EntityManager entityManager;

	public List<Municipio> findAll() throws DataAccessException {
		return municipioRepository.findAll();
	}

	public List<Municipio> findAll(Sort sort) {
		return municipioRepository.findAll(sort);
	}

	public List<Municipio> findbyDpto(Integer codigo) throws DataAccessException {
		return municipioRepository.findMuniByIdDpto(codigo);
	}

	public Municipio findOne(Integer code) throws DataAccessException {
		return municipioRepository.getOne(code);
	}

}
