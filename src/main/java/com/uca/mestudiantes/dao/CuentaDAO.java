package com.uca.mestudiantes.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.uca.mestudiantes.domain.Cuenta;

public interface CuentaDAO {
	
	public List<Cuenta> findAll() throws DataAccessException;	
	public Cuenta findOne(Integer code) throws DataAccessException;
	public void insertar(Cuenta c) throws DataAccessException;

}
