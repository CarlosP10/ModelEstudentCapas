package com.uca.modele.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.uca.modele.dao.ExpedienteDAO;
import com.uca.modele.domain.Expediente;


@Repository
public class ExpedienteDAOImpl implements ExpedienteDAO{

	@PersistenceContext(unitName = "modele")
	private EntityManager entityManager;

	public List<Expediente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.expediente");
		Query query = entityManager.createNativeQuery(sb.toString(),Expediente.class);
		List<Expediente> resulset= query.getResultList();
		
		return resulset;
	}

	public Expediente findOne(Integer code) throws DataAccessException {
		Expediente expediente = entityManager.find(Expediente.class, code);
		return expediente;
	}

	public void save(Expediente c) throws DataAccessException {
		if(c.getIdExpediente() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c); 
		}		
	}

}
