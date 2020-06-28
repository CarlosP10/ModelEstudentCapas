package com.uca.mestudiantes.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.mestudiantes.domain.MateriasxAlumno;

public interface MateriasxAlumnoDAO {
	
	public List<MateriasxAlumno> findAll() throws DataAccessException;	
	public MateriasxAlumno findOne(Integer code) throws DataAccessException;
	public void insertar(MateriasxAlumno c) throws DataAccessException;	

}
