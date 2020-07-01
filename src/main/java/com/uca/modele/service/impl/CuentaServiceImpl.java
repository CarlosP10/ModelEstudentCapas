package com.uca.modele.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.uca.modele.dao.CuentaDAO;
import com.uca.modele.domain.Cuenta;
import com.uca.modele.repository.CuentaRepository;
import com.uca.modele.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService{
	
	@Autowired
	CuentaDAO cuentaDao;
	
	@Autowired
	CuentaRepository cuentaRepository;
	
	@PersistenceContext(unitName = "modele")
	EntityManager entityManager;

	@Override
	public List<Cuenta> findAll() throws DataAccessException {
		return cuentaRepository.findAllCuentas();
	}

	@Override
	public Cuenta findOne(Integer codigo) throws DataAccessException {
		return cuentaRepository.findCuentateById(codigo);
	}

	@Override
	public void save(Cuenta c) throws DataAccessException {
		 cuentaDao.save(c);
		
	}

	@Override
	public void updateCuenta(Cuenta c) throws DataAccessException {
		 cuentaDao.updateCuenta(c);
		
	}

	@Override
	public int insertar(Cuenta c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cuenta> findAllCatalogo() throws DataAccessException {
		return cuentaRepository.findAllCatalogoCuenta();
	}

	@Override
	public List<Cuenta> findAll(Sort sort) {
		return cuentaRepository.findAll(sort);
	}

}
