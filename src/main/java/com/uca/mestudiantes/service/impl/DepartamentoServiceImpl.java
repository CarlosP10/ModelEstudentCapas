package com.uca.mestudiantes.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.uca.mestudiantes.dao.DepartamentoDAO;
import com.uca.mestudiantes.domain.Departamento;
import com.uca.mestudiantes.repository.DepertamentoRepository;
import com.uca.mestudiantes.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	DepartamentoDAO dptoDao;
	
	@Autowired
	DepertamentoRepository dptoRepository;
	
	@PersistenceContext(unitName = "mestudiantes")
	EntityManager entityManager;

	@Override
	public List<Departamento> findAll() throws DataAccessException {
		return dptoRepository.findAllDptos();
	}

	@Override
	public List<Departamento> findAll(Sort sort) {
		return findAll(sort);
	}

	@Override
	public Departamento findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Departamento c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDepartamento(Departamento c) {
		// TODO Auto-generated method stub
		
	}

}
