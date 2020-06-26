package com.uca.mestudiantes.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.uca.mestudiantes.dao.ExpedienteDAO;
import com.uca.mestudiantes.domain.Expediente;


@Repository
public class ExpedienteDAOImpl implements ExpedienteDAO{

	@PersistenceContext(unitName = "mestudiantes")
	private EntityManager entityManager;

	@Override
	public List<Expediente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.expediente");
		Query query = entityManager.createNativeQuery(sb.toString(),Expediente.class);
		List<Expediente> resulset= query.getResultList();
		
		return resulset;
	}

	@Override
	public Expediente findOne(Integer code) throws DataAccessException {
		Expediente expediente = entityManager.find(Expediente.class, code);
		return expediente;
	}

	@Transactional
	public void insertar(Expediente e) throws DataAccessException {
		if(e.getId_expediente() == null) { 
			entityManager.persist(e);
		}
		else { 
			entityManager.merge(e); 
		}		
	}

}
