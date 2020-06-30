package com.uca.mestudiantes.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;

import com.uca.mestudiantes.domain.MateriasxAlumno;

public interface MateriasxAlumnoService {
	
	public List<MateriasxAlumno> findAll() throws DataAccessException;

	public List<MateriasxAlumno> findAll(Sort sort);

	public MateriasxAlumno findOne(Integer codigo) throws DataAccessException;

	public void save(MateriasxAlumno c) throws DataAccessException;

	public void updateMaterias(MateriasxAlumno c);
	
	public int insertar(MateriasxAlumno c);

}
