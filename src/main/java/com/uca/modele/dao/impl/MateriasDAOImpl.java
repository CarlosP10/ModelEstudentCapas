package com.uca.modele.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.modele.dao.MateriasDAO;
import com.uca.modele.domain.Materias;


@Repository
public class MateriasDAOImpl implements MateriasDAO{

	@PersistenceContext(unitName = "modele")
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

	public void save(Materias c) throws DataAccessException {
		if(c.getIdMateria() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c); 
		}
		
	}

}
