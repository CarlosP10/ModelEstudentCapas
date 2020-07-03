package com.uca.modele.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

	@Override
	public List<Materias> findAll() throws DataAccessException {
		return materiasRepository.findAllMaterias();
	}

	@Override
	public List<Materias> findAll(Sort sort) {
		return materiasRepository.findAll(sort);
	}

	@Override
	public Materias findOne(Integer codigo) throws DataAccessException {
		return materiasRepository.findMateriaById(codigo);
	}

	@Override
	public void save(Materias c) throws DataAccessException {
		 materiasDao.save(c);
		
	}

	@Override
	public void updateMaterias(Materias c) {
		 materiasDao.updateMaterias(c);
		
	}

	@Override
	public int insertar(Materias c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Materias> findAllCatalogo() throws DataAccessException {
		return materiasRepository.findAllCatalogoMateria();
	}

}