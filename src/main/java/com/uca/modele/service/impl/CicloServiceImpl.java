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
	
	

	@Override
	public List<Ciclo> findAll() throws DataAccessException {
		return cicloRepository.findAllCiclos();
	}

	@Override
	public List<Ciclo> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ciclo findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Ciclo c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCiclo(Ciclo c) {
		// TODO Auto-generated method stub
		
	}

}
