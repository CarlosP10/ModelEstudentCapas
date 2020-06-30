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
import com.uca.mestudiantes.dao.CuentaDAO;
import com.uca.mestudiantes.domain.Cuenta;

@Repository
public class CuentaDAOImpl implements CuentaDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String sql = "UPDATE public.cuenta SET nombre = ?, apellido = ?, fecha_nac = ?, edad = ?, id_dpto = ?, id_municipio = ?, estado = ?, nombre_usuario = ?, contrasenia = ?, id_tipo = ?, sesion = ?";

	
	@PersistenceContext(unitName = "mestudiantes")
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

	@Transactional
	public void insertar(Cuenta e) throws DataAccessException {
		if(e.getId_cuenta() == null) { 
			entityManager.persist(e);
		}
		else { 
			entityManager.merge(e); 
		}		
	}

	@Override
	public void save(Cuenta c) throws DataAccessException {
		if(c.getId_cuenta() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c); 
		}
		
	}

	@Override
	public void updateCuenta(Cuenta c) {
		Object[] parametros = new Object[] {c.getNombre(), c.getApellido(), c.getFecha_nac(), c.getEdad(), c.getId_dpto(), c.getId_municipio(), c.getEstado(), c.getNombre_usuario(), c.getContrasenia(), c.getId_tipo(), c.getSesion()};
		jdbcTemplate.update(sql, parametros);
		
	}
}
