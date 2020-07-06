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

import com.uca.modele.dao.EscuelasDAO;
import com.uca.modele.domain.Escuelas;
import com.uca.modele.repository.EscuelasRepository;
import com.uca.modele.service.EscuelasService;

@Service
public class EscuelasServiceImpl implements EscuelasService{
	
	@Autowired
	EscuelasDAO escuelasDao;
	
	@Autowired
	EscuelasRepository escuelasRepository;
	
	@PersistenceContext(unitName = "modele")
	EntityManager entityManager;

	public List<Escuelas> findAll() throws DataAccessException {
		return escuelasRepository.findAll();
	}

	public List<Escuelas> findAll(Sort sort) {
		return escuelasRepository.findAll(sort);
	}

	public Escuelas findOne(Integer codigo) throws DataAccessException {
		return escuelasRepository.getOne(codigo);
	}

	@Transactional
	public void save(Escuelas c) throws DataAccessException {
		 escuelasDao.save(c);		
	}

	public List<Escuelas> findAllCatalogo() throws DataAccessException {
		return escuelasRepository.findAllCatalogoEscuela();
	}

	public List<Escuelas> findOnebyDpto(Integer codigo) throws DataAccessException {
		return escuelasRepository.findEscuelaByDepartamento(codigo);
	}

	public Page<Escuelas> findAll(Pageable page) throws DataAccessException {
		return escuelasRepository.findAll(page);
	}

	@Override
	public Long countAll() {
		return escuelasRepository.count();
	}

}
