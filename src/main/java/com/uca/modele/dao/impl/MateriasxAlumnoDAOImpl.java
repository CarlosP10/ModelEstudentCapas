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
import com.uca.modele.dao.MateriasxAlumnoDAO;
import com.uca.modele.domain.MateriasxAlumno;


@Repository
public class MateriasxAlumnoDAOImpl implements MateriasxAlumnoDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String sql = "UPDATE public.materiaxalumno SET id_expediente = ?, id_ciclo = ?, id_materia = ?, anio = ?, nota = ?";


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

	@Transactional
	public void insertar(MateriasxAlumno e) throws DataAccessException {
		if(e.getId_materiaexp() == null) { 
			entityManager.persist(e);
		}
		else { 
			entityManager.merge(e); 
		}		
	}

	@Override
	public void save(MateriasxAlumno c) throws DataAccessException {
		if(c.getId_materiaexp() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c); 
		}
		
	}

	@Override
	public void updateMateriasxAlumno(MateriasxAlumno c) {
		Object[] parametros = new Object[] {c.getId_expediente(), c.getId_ciclo(), c.getId_materia(), c.getAnio(), c.getNota()};
		jdbcTemplate.update(sql, parametros);
	}

}