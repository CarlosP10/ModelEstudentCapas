package com.uca.modele.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.uca.modele.domain.Escuelas;
import com.uca.modele.domain.MateriasxAlumno;

public interface MateriasxAlumnoDAO {
	
	public List<MateriasxAlumno> findAll() throws DataAccessException;	
	public MateriasxAlumno findOne(Integer code) throws DataAccessException;
	public void insertar(MateriasxAlumno c) throws DataAccessException;	
	public void save(MateriasxAlumno c) throws DataAccessException;
	public void updateMateriasxAlumno(MateriasxAlumno c);

}
