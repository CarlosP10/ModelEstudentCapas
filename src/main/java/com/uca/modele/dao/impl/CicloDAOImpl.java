package com.uca.modele.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.uca.modele.dao.CicloDAO;
import com.uca.modele.domain.Ciclo;

@Repository
public class CicloDAOImpl implements CicloDAO{
	
	@PersistenceContext(unitName = "modele")
	private EntityManager entityManager;

	@Override
	public List<Ciclo> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.ciclo");
		Query query = entityManager.createNativeQuery(sb.toString(),Ciclo.class);
		List<Ciclo> resulset= query.getResultList();
		
		return resulset;
	}

	@Override
	public Ciclo findOne(Integer code) throws DataAccessException {
		Ciclo ciclo = entityManager.find(Ciclo.class, code);
		return ciclo;
	}

}
