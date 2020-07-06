package com.uca.modele.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.modele.domain.Escuelas;

public interface EscuelasDAO {
	public List<Escuelas> findAll() throws DataAccessException;	
	public Escuelas findOne(Integer code) throws DataAccessException;
	public void save(Escuelas c) throws DataAccessException;

}
