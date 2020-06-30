package com.uca.mestudiantes.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.uca.mestudiantes.dao.ExpedienteDAO;
import com.uca.mestudiantes.domain.Expediente;
import com.uca.mestudiantes.repository.ExpedienteRepository;
import com.uca.mestudiantes.service.ExpedienteService;

@Service
public class ExpedienteServiceImpl implements ExpedienteService{
	
	@Autowired
	ExpedienteDAO expedienteDao;
	
	@Autowired
	ExpedienteRepository expedienteRepository;
	
	@PersistenceContext(unitName = "mestudiantes")
	EntityManager entityManager;

	@Override
	public List<Expediente> findAll() throws DataAccessException {
		return expedienteRepository.findAllExpedientes();
	}

	@Override
	public List<Expediente> findAll(Sort sort) {
		return expedienteRepository.findAll(sort);
	}

	@Override
	public Expediente findOne(Integer codigo) throws DataAccessException {
		return expedienteRepository.findByIdExp(codigo);
	}

	@Override
	public void save(Expediente c) throws DataAccessException {
		 expedienteDao.save(c);		
	}

	@Override
	public void updateExpediente(Expediente c) {
		 expedienteDao.updateExpediente(c);		
	}

	@Override
	public int insertar(Expediente c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Expediente findByName(String nombre) throws DataAccessException {
		return expedienteRepository.mostrarPorNombre(nombre);
	}

	@Override
	public Expediente findByLastName(String aoellido) throws DataAccessException {
		return expedienteRepository.mostrarPorApellido(aoellido);
	}



}
