package com.uca.modele.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public List<MateriasxAlumno> findAllMatbyIdExp(Integer id) throws DataAccessException {
		return materiasxAlumnoRepository.findMateriasxAlumnoByIdExpediente(id);
	}

	public List<MateriasxAlumno> findAll(Sort sort) {
		return materiasxAlumnoRepository.findAll(sort);
	}

	public MateriasxAlumno findOne(Integer codigo) throws DataAccessException {
		return materiasxAlumnoRepository.getOne(codigo);
	}
	
	@Transactional
	public void save(MateriasxAlumno c) throws DataAccessException {
		materiasxAlumnoDao.save(c);
		
	}

	public Page<MateriasxAlumno> findAll(Pageable page) throws DataAccessException {
		return materiasxAlumnoRepository.findAll(page);
	}

	public Long countAll() {
		return materiasxAlumnoRepository.count();
	}

	public Integer getAprobadas(Integer id) throws DataAccessException {
		return materiasxAlumnoRepository.getAprobadas(id);
	}

	public Integer getReprobadas(Integer id) throws DataAccessException {
		return materiasxAlumnoRepository.getReprobadas(id);
	}

	public Float getProm(Integer id) throws DataAccessException {
		return materiasxAlumnoRepository.getPromedio(id);
	}

}
