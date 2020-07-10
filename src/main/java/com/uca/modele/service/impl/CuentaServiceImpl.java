package com.uca.modele.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<Cuenta> findAll() throws DataAccessException {
		return cuentaRepository.findAllCuentas();
	}

	public Cuenta findOne(Integer codigo) throws DataAccessException {
		return cuentaRepository.findCuentateById(codigo);
	}

	@Transactional
	public void save(Cuenta c) throws DataAccessException {
		 cuentaDao.save(c);		
	}

	@Override
	public List<Cuenta> findAllCatalogo() throws DataAccessException {
		return cuentaRepository.findAllCatalogoCuenta();
	}

	public List<Cuenta> findAll(Sort sort) {
		return cuentaRepository.findAll(sort);
	}

	public Page<Cuenta> findAll(Pageable page) throws DataAccessException {
		return cuentaRepository.findAll(page);
	}

	public Long countAll() {
		return cuentaRepository.count();
	}

	@Override
	public Cuenta login(String nombre_usuario, String contrasenia) throws DataAccessException {
		return cuentaRepository.login(nombre_usuario, contrasenia);
	}

	@Override
	public Cuenta findOneUserName(String dataS) throws DataAccessException {
		return cuentaRepository.findCuentateByUsername(dataS);
	}

}
