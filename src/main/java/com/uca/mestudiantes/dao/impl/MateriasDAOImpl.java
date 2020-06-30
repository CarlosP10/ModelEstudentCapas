package com.uca.mestudiantes.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uca.mestudiantes.dao.MateriasDAO;
import com.uca.mestudiantes.domain.Materias;


@Repository
public class MateriasDAOImpl implements MateriasDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String sql = "UPDATE public.materia SET nombres = ?, estado = ?, descripcion = ?";

	@PersistenceContext(unitName = "mestudiantes")
	private EntityManager entityManager;

	@Override
	public List<Materias> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.materias");
		Query query = entityManager.createNativeQuery(sb.toString(),Materias.class);
		List<Materias> resulset= query.getResultList();
		
		return resulset;
	}

	@Override
	public Materias findOne(Integer code) throws DataAccessException {
		Materias materias = entityManager.find(Materias.class, code);
		return materias;
	}

	@Transactional
	public void insertar(Materias e) throws DataAccessException {
		if(e.getId_materia() == null) { 
			entityManager.persist(e);
		}
		else { 
			entityManager.merge(e); 
		}		
	}

	@Override
	public void save(Materias c) throws DataAccessException {
		if(c.getId_materia() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c); 
		}
		
	}

	@Override
	public void updateMaterias(Materias c) {
		Object[] parametros = new Object[] {c.getNombre(), c.getEstado(), c.getDescripcion()};
		jdbcTemplate.update(sql, parametros);
		
	}

}
