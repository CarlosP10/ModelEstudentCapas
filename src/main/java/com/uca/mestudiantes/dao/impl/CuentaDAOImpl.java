package com.uca.mestudiantes.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.uca.mestudiantes.dao.CuentaDAO;
import com.uca.mestudiantes.domain.Cuenta;

@Repository
public class CuentaDAOImpl implements CuentaDAO{
	
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
}
