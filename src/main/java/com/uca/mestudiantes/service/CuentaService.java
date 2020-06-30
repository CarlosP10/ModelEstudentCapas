package com.uca.mestudiantes.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;

import com.uca.mestudiantes.domain.Cuenta;

public interface CuentaService {
	
	public List<Cuenta> findAll() throws DataAccessException;

	public List<Cuenta> findAll(Sort sort);

	public Cuenta findOne(Integer codigo) throws DataAccessException;

	public void save(Cuenta c) throws DataAccessException;

	public void updateCuenta(Cuenta c);
	
	public int insertar(Cuenta c);

}
