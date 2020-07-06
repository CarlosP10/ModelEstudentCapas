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
import com.uca.modele.dao.CuentaDAO;
import com.uca.modele.domain.Cuenta;

@Repository
public class CuentaDAOImpl implements CuentaDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String sql = "UPDATE public.cuenta SET nombre = ?, apellido = ?, fecha_nac = ?, edad = ?, id_dpto = ?, id_municipio = ?, estado = ?, nombre_usuario = ?, contrasenia = ?, id_tipo = ?, sesion = ?";

	
	@PersistenceContext(unitName = "modele")
	private EntityManager entityManager;

	@Override
	public List<Cuenta> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cuenta");
		Query query = entityManager.createNativeQuery(sb.toString(),Cuenta.class);
		List<Cuenta> resulset= query.getResultList();
		
		return resulset;
	}

	@Override
	public Cuenta findOne(Integer code) throws DataAccessException {
		Cuenta cuenta = entityManager.find(Cuenta.class, code);
		return cuenta;
	}

	public void save(Cuenta c) throws DataAccessException {
		if(c.getIdCuenta() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c); 
		}
		
	}
}
