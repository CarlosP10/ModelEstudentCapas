package com.uca.modele.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.uca.modele.dao.TipoUsuarioDAO;
import com.uca.modele.domain.TipoUsuario;
import com.uca.modele.repository.TipoUsuarioRepository;
import com.uca.modele.service.TipoUsuarioService;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService{
	
	@Autowired
	TipoUsuarioDAO tipoUsuarioDao;
	
	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;
	
	@PersistenceContext(unitName = "modele")
	EntityManager entityManager;

	public List<TipoUsuario> findAll() throws DataAccessException {
		return tipoUsuarioRepository.findAll();
	}

	public List<TipoUsuario> findAll(Sort sort) {
		return tipoUsuarioRepository.findAll(sort);
	}

	public TipoUsuario findOne(Integer codigo) throws DataAccessException {
		return tipoUsuarioRepository.getOne(codigo);
	}


}
