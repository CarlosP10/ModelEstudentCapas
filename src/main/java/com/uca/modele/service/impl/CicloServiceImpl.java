package com.uca.modele.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.uca.modele.dao.CicloDAO;
import com.uca.modele.domain.Ciclo;
import com.uca.modele.repository.CicloRepository;
import com.uca.modele.service.CicloService;

@Service
public class CicloServiceImpl implements CicloService{
	
	@Autowired
	CicloDAO cicloDao;
	
	@Autowired
	CicloRepository cicloRepository;
	
	@PersistenceContext(unitName = "modele")
	EntityManager entityManager;

	public List<Ciclo> findAll() throws DataAccessException {
		return cicloRepository.findAllCiclos();
	}

	public List<Ciclo> findAll(Sort sort) {
		return cicloRepository.findAll(sort);
	}

	public Ciclo findOne(Integer codigo) throws DataAccessException {
		return cicloRepository.getOne(codigo);
	}

}
