package com.uca.modele.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.modele.domain.Materias;

public interface MateriasDAO {
	public List<Materias> findAll() throws DataAccessException;	
	public Materias findOne(Integer code) throws DataAccessException;
	public void save(Materias c) throws DataAccessException;

}
