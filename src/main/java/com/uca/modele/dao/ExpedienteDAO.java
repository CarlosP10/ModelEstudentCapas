package com.uca.modele.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.modele.domain.Expediente;

public interface ExpedienteDAO {
	
	public List<Expediente> findAll() throws DataAccessException;	
	public Expediente findOne(Integer code) throws DataAccessException;
	public void insertar(Expediente c) throws DataAccessException;	
	public void save(Expediente c) throws DataAccessException;
	public void updateExpediente(Expediente c);

}
