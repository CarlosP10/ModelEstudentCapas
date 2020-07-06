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

import com.uca.modele.dao.MateriasDAO;
import com.uca.modele.domain.Materias;
import com.uca.modele.repository.MateriasRepository;
import com.uca.modele.service.MateriasService;

@Service
public class MateriasServiceImpl implements MateriasService{
	
	@Autowired
	MateriasDAO materiasDao;
	
	@Autowired
	MateriasRepository materiasRepository;
	
	@PersistenceContext(unitName = "modele")
	EntityManager entityManager;

	public List<Materias> findAll() throws DataAccessException {
		return materiasRepository.findAll();
	}

	public List<Materias> findAll(Sort sort) {
		return materiasRepository.findAll(sort);
	}

	public Materias findOne(Integer codigo) throws DataAccessException {
		return materiasRepository.getOne(codigo);
	}

	@Transactional
	public void save(Materias c) throws DataAccessException {
		 materiasDao.save(c);
		
	}

	public List<Materias> findAllCatalogo() throws DataAccessException {
		return materiasRepository.findAllCatalogoMateria();
	}

	public Page<Materias> findAll(Pageable page) throws DataAccessException {
		return materiasRepository.findAll(page);
	}

	public Long countAll() {
		return materiasRepository.count();
	}

}
