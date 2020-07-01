package com.uca.modele.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.modele.domain.Escuelas;
import com.uca.modele.domain.Expediente;

public interface EscuelasDAO {
	public List<Escuelas> findAll() throws DataAccessException;	
	public Escuelas findOne(Integer code) throws DataAccessException;
	public void insertar(Escuelas c) throws DataAccessException;	
	public void save(Escuelas c) throws DataAccessException;
	public void updateEscuelas(Escuelas c);

}
