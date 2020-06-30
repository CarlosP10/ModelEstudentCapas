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
import com.uca.mestudiantes.dao.EscuelasDAO;
import com.uca.mestudiantes.domain.Escuelas;

@Repository
public class EscuelasDAOImpl implements EscuelasDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String sql = "UPDATE public.escuelas SET nombre = ?, estado = ?, descripcion = ?, id_dpto = ?";

	
	@PersistenceContext(unitName = "mestudiantes")
	private EntityManager entityManager;

	@Override
	public List<Escuelas> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.escuelas");
		Query query = entityManager.createNativeQuery(sb.toString(),Escuelas.class);
		List<Escuelas> resulset= query.getResultList();
		
		return resulset;
	}

	@Override
	public Escuelas findOne(Integer code) throws DataAccessException {
		Escuelas escuelas = entityManager.find(Escuelas.class, code);
		return escuelas;
	}

	@Transactional
	public void insertar(Escuelas e) throws DataAccessException {
		if(e.getId_escuela() == null) { 
			entityManager.persist(e);
		}
		else { 
			entityManager.merge(e); 
		}
		
	}

	@Override
	public void save(Escuelas c) throws DataAccessException {
		if(c.getId_escuela() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c); 
		}
		
	}

	@Override
	public void updateEscuelas(Escuelas c) {
		Object[] parametros = new Object[] {c.getNombre(), c.getEstado(), c.getDescripcion(), c.getId_dpto()};
		jdbcTemplate.update(sql, parametros);
		
	}

}
