package com.uca.mestudiantes.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.uca.mestudiantes.dao.TipoUsuarioDAO;
import com.uca.mestudiantes.domain.TipoUsuario;
import com.uca.mestudiantes.repository.TipoUsuarioRepository;
import com.uca.mestudiantes.service.TipoUsuarioService;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService{
	
	@Autowired
	TipoUsuarioDAO tipoUsuarioDao;
	
	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;
	
	@PersistenceContext(unitName = "mestudiantes")
	EntityManager entityManager;

	@Override
	public List<TipoUsuario> findAll() throws DataAccessException {
		return tipoUsuarioRepository.findAllTipos();
	}

	@Override
	public List<TipoUsuario> findAll(Sort sort) {
		return tipoUsuarioRepository.findAll(sort);
	}

	@Override
	public TipoUsuario findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TipoUsuario c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTipoUsuario(TipoUsuario c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insertar(TipoUsuario c) {
		// TODO Auto-generated method stub
		return 0;
	}

}
