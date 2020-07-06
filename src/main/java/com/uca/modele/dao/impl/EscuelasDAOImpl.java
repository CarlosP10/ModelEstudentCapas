package com.uca.modele.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.uca.modele.dao.EscuelasDAO;
import com.uca.modele.domain.Escuelas;

@Repository
public class EscuelasDAOImpl implements EscuelasDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PersistenceContext(unitName = "modele")
	private EntityManager entityManager;

	@Override
	public List<Escuelas> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.escuelas");
		Query query = entityManager.createNativeQuery(sb.toString(),Escuelas.class);
		List<Escuelas> resulset= query.getResultList();
		
		return resulset;
	}
	
	public Escuelas findOne(Integer code) throws DataAccessException {
		Escuelas escuelas = entityManager.find(Escuelas.class, code);
		return escuelas;
	}
	
	public void save(Escuelas c) throws DataAccessException {
		if(c.getIdEscuela() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c); 
		}
		
	}

}
