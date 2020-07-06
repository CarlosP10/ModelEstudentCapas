package com.uca.modele.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.uca.modele.dao.DepartamentoDAO;
import com.uca.modele.domain.Departamento;
import com.uca.modele.repository.DepertamentoRepository;
import com.uca.modele.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	DepartamentoDAO dptoDao;
	
	@Autowired
	DepertamentoRepository dptoRepository;
	
	@PersistenceContext(unitName = "modele")
	EntityManager entityManager;

	public List<Departamento> findAll() throws DataAccessException {
		return dptoRepository.findAllDptos();
	}

	public List<Departamento> findAll(Sort sort) {
		return findAll(sort);
	}

	public Departamento findOne(Integer id) throws DataAccessException {
		return dptoRepository.getOne(id);
	}

}
