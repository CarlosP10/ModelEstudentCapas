package com.uca.modele.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.uca.modele.dao.MateriasxAlumnoDAO;
import com.uca.modele.domain.MateriasxAlumno;


@Repository
public class MateriasxAlumnoDAOImpl implements MateriasxAlumnoDAO{


	@PersistenceContext(unitName = "modele")
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

	public void save(MateriasxAlumno c) throws DataAccessException {
		if(c.getIdMateriaexp() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c); 
		}
		
	}

}
