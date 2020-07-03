package com.uca.modele.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.uca.modele.domain.Materias;

public interface MateriasService {
	
	public List<Materias> findAll() throws DataAccessException;
	
	public List<Materias> findAllCatalogo() throws DataAccessException;
	
	public Page<Materias> findAll(Pageable page) throws DataAccessException;
	
	public Long countAll();

	public List<Materias> findAll(Sort sort);

	public Materias findOne(Integer codigo) throws DataAccessException;

	public void save(Materias c) throws DataAccessException;

	public void updateMaterias(Materias c);
	
	public int insertar(Materias c);

}
