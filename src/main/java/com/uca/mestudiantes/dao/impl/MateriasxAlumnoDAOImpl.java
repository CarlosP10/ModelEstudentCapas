package com.uca.mestudiantes.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.uca.mestudiantes.dao.MateriasxAlumnoDAO;
import com.uca.mestudiantes.domain.MateriasxAlumno;


@Repository
public class MateriasxAlumnoDAOImpl implements MateriasxAlumnoDAO{

	@PersistenceContext(unitName = "mestudiantes")
	private EntityManager entityManager;

	@Override
	public List<MateriasxAlumno> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.materiaxalumno");
		Query query = entityManager.createNativeQuery(sb.toString(),MateriasxAlumno.class);
		List<MateriasxAlumno> resulset= query.getResultList();
		
		return resulset;
	}

	@Override
	public MateriasxAlumno findOne(Integer code) throws DataAccessException {
		MateriasxAlumno materiaxalumno = entityManager.find(MateriasxAlumno.class, code);
		return materiaxalumno;
	}

	@Transactional
	public void insertar(MateriasxAlumno e) throws DataAccessException {
		if(e.getId_materiaexp() == null) { 
			entityManager.persist(e);
		}
		else { 
			entityManager.merge(e); 
		}		
	}

}
