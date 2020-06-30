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
import com.uca.mestudiantes.dao.ExpedienteDAO;
import com.uca.mestudiantes.domain.Expediente;


@Repository
public class ExpedienteDAOImpl implements ExpedienteDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String sql = "UPDATE public.expediente SET nombres = ?, apellidos = ?, fecha_nacimiento = ?, edad = ?, direccion= ?, telefono_fijo = ?, telefono_movil = ?, id_escuela = ?, nombre_padre = ?, nombre_madre = ?";

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

	@Override
	public void save(Expediente c) throws DataAccessException {
		if(c.getId_expediente() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c); 
		}
		
	}

	
	@Override
	public void updateExpediente(Expediente c) {
		Object[] parametros = new Object[] {c.getNombres(), c.getApellidos(), c.getFecha_nacimiento(), c.getEdad(), c.getDireccion(), c.getTelefono_fijo(), c.getTelefono_movil(), c.getId_escuela(), c.getNombre_padre(), c.getNombre_madre()};
		jdbcTemplate.update(sql, parametros);
		
	}

}
