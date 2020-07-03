package com.uca.modele.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.uca.modele.dao.MateriasxAlumnoDAO;
import com.uca.modele.domain.MateriasxAlumno;
import com.uca.modele.repository.MateriasxAlumnoRepository;
import com.uca.modele.service.MateriasxAlumnoService;

@Service
public class MateriasxAlumnoServiceImpl implements MateriasxAlumnoService{
	
	@Autowired
	MateriasxAlumnoDAO materiasxAlumnoDao;
	
	@Autowired
	MateriasxAlumnoRepository materiasxAlumnoRepository;
	
	@PersistenceContext(unitName = "modele")
	EntityManager entityManager;

	@Override
	public List<MateriasxAlumno> findAll() throws DataAccessException {
		return materiasxAlumnoRepository.findAllMateriasxAlumno();
	}

	@Override
	public List<MateriasxAlumno> findAll(Sort sort) {
		return materiasxAlumnoRepository.findAll(sort);
	}

	@Override
	public MateriasxAlumno findOne(Integer codigo) throws DataAccessException {
		return materiasxAlumnoRepository.findMateriasxAlumnoByIdExpediente(codigo);
	}

	@Override
	public void save(MateriasxAlumno c) throws DataAccessException {
		materiasxAlumnoDao.save(c);
		
	}

	@Override
	public void updateMaterias(MateriasxAlumno c) {
		 materiasxAlumnoDao.updateMateriasxAlumno(c);
		
	}

	@Override
	public int insertar(MateriasxAlumno c) {
		// TODO Auto-generated method stub
		return 0;
	}

}