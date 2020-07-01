package com.uca.modele.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
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

	@Override
	public List<Escuelas> findAll() throws DataAccessException {
		return escuelasRepository.findAllEscuelas();
	}

	@Override
	public List<Escuelas> findAll(Sort sort) {
		return escuelasRepository.findAll(sort);
	}

	@Override
	public Escuelas findOne(Integer codigo) throws DataAccessException {
		return escuelasRepository.findEscuelaById(codigo);
	}

	@Override
	public void save(Escuelas c) throws DataAccessException {
		 escuelasDao.save(c);
		
	}

	@Override
	public void updateEscuelas(Escuelas c) {
		 escuelasDao.updateEscuelas(c);
		
	}

	@Override
	public int insertar(Escuelas c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Escuelas> findAllCatalogo() throws DataAccessException {
		return escuelasRepository.findAllCatalogoEscuela();
	}

	@Override
	public List<Escuelas> findOnebyDpto(Integer codigo) throws DataAccessException {
		return escuelasRepository.findEscuelaByDepartamento(codigo);
	}

}
