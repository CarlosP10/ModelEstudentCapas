package com.uca.modele.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.uca.modele.domain.MateriasxAlumno;

public interface MateriasxAlumnoService {
	
	public List<MateriasxAlumno> findAllMatbyIdExp(Integer id) throws DataAccessException;	

	public List<MateriasxAlumno> findAll(Sort sort);
	
	public Page<MateriasxAlumno> findAll(Pageable page) throws DataAccessException;

	public MateriasxAlumno findOne(Integer codigo) throws DataAccessException;

	public void save(MateriasxAlumno c) throws DataAccessException;
	
	public Integer getAprobadas(Integer id) throws DataAccessException;
	public Integer getReprobadas(Integer id) throws DataAccessException;
	public Float getProm(Integer id) throws DataAccessException;
	
	public Long countAll();

}
