package com.uca.modele.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.modele.dao.ExpedienteDAO;
import com.uca.modele.domain.Expediente;
import com.uca.modele.repository.ExpedienteRepository;
import com.uca.modele.service.ExpedienteService;

@Service
public class ExpedienteServiceImpl implements ExpedienteService{
	
	@Autowired
	ExpedienteDAO expedienteDao;
	
	@Autowired
	ExpedienteRepository expedienteRepository;
	
	@PersistenceContext(unitName = "modele")
	EntityManager entityManager;

	public List<Expediente> findAll() throws DataAccessException {
		return expedienteRepository.findAll();
	}

	public List<Expediente> findAll(Sort sort) {
		return expedienteRepository.findAll(sort);
	}

	public Expediente findOne(Integer codigo) throws DataAccessException {
		return expedienteRepository.getOne(codigo);
	}

	@Transactional
	public void save(Expediente c) throws DataAccessException {
		 expedienteDao.save(c);		
	}

	public Expediente findByName(String nombre) throws DataAccessException {
		return expedienteRepository.mostrarPorNombre(nombre);
	}

	public Expediente findByLastName(String aoellido) throws DataAccessException {
		return expedienteRepository.mostrarPorApellido(aoellido);
	}



}
