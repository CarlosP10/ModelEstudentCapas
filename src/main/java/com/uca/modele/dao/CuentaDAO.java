package com.uca.modele.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.uca.modele.domain.Cuenta;

public interface CuentaDAO {
	
	public List<Cuenta> findAll() throws DataAccessException;	
	public Cuenta findOne(Integer code) throws DataAccessException;
	public void save(Cuenta c) throws DataAccessException;

}
