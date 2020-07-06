package com.uca.modele.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;

import com.uca.modele.domain.MateriasxAlumno;

public interface MateriasxAlumnoService {
	
	public List<MateriasxAlumno> findAll() throws DataAccessException;

	public List<MateriasxAlumno> findAll(Sort sort);

	public MateriasxAlumno findOne(Integer codigo) throws DataAccessException;

	public void save(MateriasxAlumno c) throws DataAccessException;

}
