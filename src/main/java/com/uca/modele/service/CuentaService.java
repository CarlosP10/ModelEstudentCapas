package com.uca.modele.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;

import com.uca.modele.domain.Cuenta;
import com.uca.modele.domain.Materias;

public interface CuentaService {
	
	public List<Cuenta> findAll() throws DataAccessException;

	public List<Cuenta> findAllCatalogo()throws DataAccessException;
	
	public List<Cuenta> findAll(Sort sort);

	public Cuenta findOne(Integer codigo) throws DataAccessException;

	public void save(Cuenta c) throws DataAccessException;

	public void updateCuenta(Cuenta c) throws DataAccessException;
	
	public int insertar(Cuenta c);

}
