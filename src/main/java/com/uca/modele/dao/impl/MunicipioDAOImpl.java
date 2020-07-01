package com.uca.modele.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.uca.modele.dao.MunicipioDAO;
import com.uca.modele.domain.Municipio;


@Repository
public class MunicipioDAOImpl implements MunicipioDAO{

	@PersistenceContext(unitName = "modele")
	private EntityManager entityManager;

	@Override
	public List<Municipio> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.municipio");
		Query query = entityManager.createNativeQuery(sb.toString(),Municipio.class);
		List<Municipio> resulset= query.getResultList();
		
		return resulset;
	}

	@Override
	public Municipio findOne(Integer code) throws DataAccessException {
		Municipio municipio = entityManager.find(Municipio.class, code);
		return municipio;
	}

}
